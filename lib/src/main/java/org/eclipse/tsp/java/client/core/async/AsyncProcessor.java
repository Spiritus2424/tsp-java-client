package org.eclipse.tsp.java.client.core.async;

import static java.util.stream.Collectors.joining;
import static javax.lang.model.element.ElementKind.FIELD;

import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import com.google.auto.service.AutoService;

@SupportedAnnotationTypes("org.eclipse.tsp.java.client.core.async.Async")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class AsyncProcessor extends AbstractProcessor {
	// @Override
	// public boolean process(Set<? extends TypeElement> annotations,
	// RoundEnvironment roundEnvironment) {

	// for (Element element :
	// roundEnvironment.getElementsAnnotatedWith(Async.class)) {
	// // if (element.getKind() != ElementKind.METHOD) {
	// // // handle the error condition
	// // continue;
	// // }

	// ExecutableElement methodElement = (ExecutableElement) element;
	// TypeElement classElement = (TypeElement) methodElement.getEnclosingElement();

	// // generate the new method name
	// String newMethodName = String.format("%sAsync",
	// methodElement.getSimpleName().toString());

	// // create the new method
	// MethodSpec newMethod = MethodSpec.methodBuilder(newMethodName)
	// .addModifiers(Modifier.PUBLIC)
	// .returns(void.class)
	// .addStatement("System.out.println(\"This is a generated method.\")")
	// .build();

	// // add the new method to the class
	// TypeSpec updatedClass =
	// TypeSpec.classBuilder(classElement.getSimpleName().toString())
	// .addModifiers(Modifier.PUBLIC)
	// .addMethod(newMethod)
	// .build();

	// // write the updated class to a file
	// try {
	// JavaFile.builder(classElement.getEnclosingElement().toString(), updatedClass)
	// .build()
	// .writeTo(processingEnv.getFiler());
	// processingEnv.getFiler().createSourceFile("patate").openWriter().write();
	// } catch (IOException e) {
	// // handle the error
	// }
	// }

	// return true;
	// }

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		annotations.forEach(annotation -> roundEnv.getElementsAnnotatedWith(annotation)
				.forEach(this::generateBuilderFile));
		return true;
	}

	private void generateBuilderFile(Element element) {
		String className = element.getSimpleName().toString();
		String packageName = element.getEnclosingElement().toString();
		String builderName = className + "org.eclipse.tsp.java.client.Builder";
		String builderFullName = packageName + "." + builderName;
		List<? extends Element> fields = element.getEnclosedElements()
				.stream().filter(e -> FIELD.equals(e.getKind())).toList();

		try (PrintWriter writer = new PrintWriter(
				processingEnv.getFiler().createSourceFile(builderFullName).openWriter())) {
			writer.println("""
					package %s;

					public class %s {
					"""
					.formatted(packageName, builderName));

			fields.forEach(field -> writer.print("""
					    private %s %s;
					""".formatted(field.asType().toString(), field.getSimpleName())));

			writer.println();
			fields.forEach(field -> writer.println("""
					    public %s %s(%s value) {
					        %s = value;
					        return this;
					    }
					""".formatted(builderName, field.getSimpleName(),
					field.asType().toString(), field.getSimpleName())));

			writer.println("""
					    public %s build() {
					        return new %s(%s);
					    }
					""".formatted(className, className,
					fields.stream().map(Element::getSimpleName).collect(joining(", "))));
			writer.println("}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
