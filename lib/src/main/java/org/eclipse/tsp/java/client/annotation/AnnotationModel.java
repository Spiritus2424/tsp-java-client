package org.eclipse.tsp.java.client.annotation;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class AnnotationModel {
    @NonNull
    private Map<String, List<Annotation>> annotations;

}
