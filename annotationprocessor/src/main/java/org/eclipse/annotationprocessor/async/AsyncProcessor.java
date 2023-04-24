package org.eclipse.annotationprocessor.async;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;

@SupportedAnnotationTypes("org.eclipse.annotationprocessor.async.Async")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class AsyncProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {

		Map<String, List<Element>> classMethodElements = new HashMap<>();

		annotations.stream().forEach((TypeElement annotation) -> {
			roundEnvironment.getElementsAnnotatedWith(annotation).stream().forEach((Element element) -> {
				if (!classMethodElements.containsKey(element.getEnclosingElement().toString())) {
					classMethodElements.put(element.getEnclosingElement().toString(), new ArrayList<Element>());
				}
				if (element.getKind() == ElementKind.METHOD) {
					classMethodElements.get(element.getEnclosingElement().toString()).add(element);
				}
			});
		});
		classMethodElements.entrySet().stream().forEach((Map.Entry<String, List<Element>> entry) -> {
			if (!entry.getValue().isEmpty()) {
				this.generateAsyncClass(entry.getKey(), entry.getValue());
			}
		});

		return true;
	}

	public void generateAsyncClass(String className, List<Element> methodElements) {
		TypeElement classElement = (TypeElement) methodElements.get(0).getEnclosingElement();
		FieldSpec syncApiField = this.generateField(classElement);
		FieldSpec executorField = this.generateExecutionServiceField();
		MethodSpec constructor = this.generateConstructor(classElement, syncApiField);

		List<MethodSpec> asyncMethods = new ArrayList<>();
		this.generateAsyncMethods(methodElements, asyncMethods, syncApiField, executorField);
		// add the new method to the class
		TypeSpec updatedClass = TypeSpec
				.classBuilder(classElement.getSimpleName().toString().concat("Async"))
				.addModifiers(Modifier.PUBLIC)
				.addField(syncApiField)
				.addField(executorField)
				.addMethod(constructor)
				.addMethods(asyncMethods)
				.build();

		// write the updated class to a file
		try {
			JavaFile.builder(classElement.getEnclosingElement().toString(), updatedClass)
					.build()
					.writeTo(processingEnv.getFiler());

		} catch (IOException e) {
			// handle the error
		}
	}

	public FieldSpec generateField(TypeElement classElement) {
		String fieldName = classElement.getSimpleName().toString().substring(0, 1).toLowerCase()
				.concat(classElement.getSimpleName().toString().substring(1));
		return FieldSpec.builder(TypeVariableName.get(classElement.getSimpleName().toString()),
				fieldName, Modifier.PRIVATE)
				.build();
	}

	public FieldSpec generateExecutionServiceField() {
		return FieldSpec.builder(TypeVariableName.get("ExecutorService"),
				"executorService", Modifier.PRIVATE)
				.build();
	}

	public MethodSpec generateConstructor(TypeElement classElement, FieldSpec fieldSpec) {
		return MethodSpec.constructorBuilder()
				.addModifiers(Modifier.PUBLIC)
				.addParameter(String.class, "baseUrl")
				.addParameter(ExecutorService.class, "executorService")
				.addStatement("this.$N = new $N(baseUrl)", fieldSpec.name, fieldSpec.type.toString())
				.addStatement("this.$N = $N", "executorService", "executorService")
				.build();
	}

	public void generateAsyncMethods(List<Element> methodElements, List<MethodSpec> methods, FieldSpec fieldSpec,
			FieldSpec executorServiceFieldSpec) {
		methodElements.stream().forEach((Element element) -> {
			ExecutableElement methodElement = (ExecutableElement) element;

			// create the new method
			MethodSpec methodSpec = MethodSpec.methodBuilder(methodElement.getSimpleName().toString())
					.addModifiers(Modifier.PUBLIC)
					.returns(this.getCompletableFuturType(methodElement))
					.addParameters(this.getParameters(methodElement))
					.addStatement(
							"return $T.supplyAsync(() -> this.$N.$N($L), this.$N)",
							CompletableFuture.class,
							fieldSpec.name, methodElement.getSimpleName(),
							String.join(", ", this.getParametersName(methodElement)),
							executorServiceFieldSpec.name)
					.build();

			methods.add(methodSpec);
		});
	}

	public List<ParameterSpec> getParameters(ExecutableElement methodElement) {
		return methodElement.getParameters().stream().map((VariableElement variableElement) -> {
			return ParameterSpec.get(variableElement);
		}).toList();
	}

	public List<String> getParametersName(ExecutableElement methodElement) {
		return methodElement.getParameters().stream().map((VariableElement variableElement) -> {
			return ParameterSpec.get(variableElement).name;
		}).toList();
	}

	public ParameterizedTypeName getCompletableFuturType(ExecutableElement methodElement) {
		return ParameterizedTypeName.get(ClassName.get(CompletableFuture.class),
				ClassName.get(methodElement.getReturnType()));
	}

}
