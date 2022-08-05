package ca.polymtl.dorsal.models.annotation;

import java.math.BigInteger;

import ca.polymtl.dorsal.models.style.OutputElementStyle;

/**
 * Annotation
 */
public class Annotation {
    private String label;
    private BigInteger time;
    private BigInteger duration;
    private int entryId;
    private String type;
    private OutputElementStyle style;

}
