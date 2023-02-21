package org.eclipse.tsp.java.client.models.annotation;

import java.math.BigInteger;

import org.eclipse.tsp.java.client.models.style.OutputElementStyle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Annotation
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Annotation {
    @NonNull
    private String label;
    @NonNull
    private BigInteger time;
    @NonNull
    private BigInteger duration;
    @NonNull
    private int entryId;
    @NonNull
    private AnnotationType type;

    private OutputElementStyle style;
}
