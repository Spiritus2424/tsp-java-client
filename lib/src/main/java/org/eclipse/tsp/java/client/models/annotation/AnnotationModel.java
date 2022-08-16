package org.eclipse.tsp.java.client.models.annotation;

import java.util.Map;

public class AnnotationModel {
    private Map<String, Annotation> annotations;

    public AnnotationModel(Map<String, Annotation> annotations) {
        this.annotations = annotations;
    }

    public Map<String, Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Map<String, Annotation> annotations) {
        this.annotations = annotations;
    }
}
