package org.eclipse.annotationprocessor.async;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

@SupportedAnnotationTypes("org.eclipse.annotationprocessor.async.Async")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class AsyncProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {

		Map<String, List<Element>> classMethodElements = new HashMap<>();
		roundEnvironment.getElementsAnnotatedWith(Async.class).stream().forEach((Element element) -> {
			if (!classMethodElements.containsKey(element.getClass().toString())) {
				classMethodElements.put(element.getClass().toString(), new ArrayList<Element>());
			}

			if (element.getKind() == ElementKind.METHOD) {
				classMethodElements.get(element.getClass().toString()).add(element);
			}
		});

		classMethodElements.entrySet().parallelStream().forEach((Map.Entry<String, List<Element>> entry) -> {
			if (!entry.getValue().isEmpty()) {
				this.generateAsyncClass(entry.getKey(), entry.getValue());
			}
		});

		return true;
	}

	public void generateAsyncClass(String className, List<Element> methodElements) {
		List<MethodSpec> asyncMethods = new ArrayList<>();

		methodElements.parallelStream().forEach((Element element) -> {
			ExecutableElement methodElement = (ExecutableElement) element;

			// generate the new method name
			String newMethodName = String.format("%sAsync",
					methodElement.getSimpleName().toString());

			// create the new method
			MethodSpec newMethod = MethodSpec.methodBuilder(newMethodName)
					.addModifiers(Modifier.PUBLIC)
					.returns(void.class)
					.addStatement("System.out.println(\"This is a generated method.\")")
					.build();

			asyncMethods.add(newMethod);
		});
		TypeElement classElement = (TypeElement) methodElements.get(0).getEnclosingElement();

		// add the new method to the class
		TypeSpec updatedClass = TypeSpec
				.classBuilder(classElement.getSimpleName().toString().concat("Async"))
				.addModifiers(Modifier.PUBLIC)
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

}
