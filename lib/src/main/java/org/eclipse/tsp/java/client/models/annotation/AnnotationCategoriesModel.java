package org.eclipse.tsp.java.client.models.annotation;

import java.util.ArrayList;

/**
 * AnnotationCategoriesModel
 */
public class AnnotationCategoriesModel {
    private ArrayList<String> annotationCategories;

    public AnnotationCategoriesModel(ArrayList<String> annotationCategories) {
        this.annotationCategories = annotationCategories;
    }

    public ArrayList<String> getAnnotationCategories() {
        return annotationCategories;
    }

    public void setAnnotationCategories(ArrayList<String> annotationCategories) {
        this.annotationCategories = annotationCategories;
    }

}