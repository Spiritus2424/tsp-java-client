package org.eclipse.tsp.java.client.api.annotation;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * AnnotationCategoriesModel
 */

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class AnnotationCategoriesModel {
    @NonNull
    private List<String> annotationCategories;

}