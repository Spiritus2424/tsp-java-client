package org.eclipse.tsp.java.client.models.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * AnnotationCategoriesModel
 */
public class AnnotationCategoriesModel {
    private List<String> annotationCategories;

    public AnnotationCategoriesModel() {
        this.annotationCategories = new ArrayList<>();
    }

    public AnnotationCategoriesModel(List<String> annotationCategories) {
        this.annotationCategories = annotationCategories;
    }

    public List<String> getAnnotationCategories() {
        return annotationCategories;
    }

    public void setAnnotationCategories(List<String> annotationCategories) {
        this.annotationCategories = annotationCategories;
    }

}