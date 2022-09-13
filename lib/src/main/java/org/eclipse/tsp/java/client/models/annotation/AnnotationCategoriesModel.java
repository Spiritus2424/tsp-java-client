package org.eclipse.tsp.java.client.models.annotation;

/**
 * AnnotationCategoriesModel
 */
public class AnnotationCategoriesModel {
    private String[] annotationCategories;

    public AnnotationCategoriesModel() {
    }

    public AnnotationCategoriesModel(String[] annotationCategories) {
        this.annotationCategories = annotationCategories;
    }

    public String[] getAnnotationCategories() {
        return annotationCategories;
    }

    public void setAnnotationCategories(String[] annotationCategories) {
        this.annotationCategories = annotationCategories;
    }

}