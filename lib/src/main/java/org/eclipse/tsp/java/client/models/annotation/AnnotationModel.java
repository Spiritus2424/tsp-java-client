package org.eclipse.tsp.java.client.models.annotation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnotationModel {
    private Map<String, List<Annotation>> annotations;

    public AnnotationModel() {
        this.annotations = new HashMap<>();
    }

    public AnnotationModel(Map<String, List<Annotation>> annotations) {
        this.annotations = annotations;
    }

    public Map<String, List<Annotation>> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Map<String, List<Annotation>> annotations) {
        this.annotations = annotations;
    }
}
