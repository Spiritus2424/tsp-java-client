package org.eclipse.tsp.java.client.models.annotation;

import java.math.BigInteger;

import org.eclipse.tsp.java.client.models.style.OutputElementStyle;

/**
 * Annotation
 */
public class Annotation {
    private String label;
    private BigInteger time;
    private BigInteger duration;
    private int entryId;
    private AnnotationType type;
    private OutputElementStyle style;

    public Annotation() {
    }

    public Annotation(String label, BigInteger time, BigInteger duration, int entryId, AnnotationType type) {
        this.label = label;
        this.time = time;
        this.duration = duration;
        this.entryId = entryId;
        this.type = type;
        this.style = null;
    }

    public Annotation(String label, BigInteger time, BigInteger duration, int entryId, AnnotationType type,
            OutputElementStyle style) {
        this.label = label;
        this.time = time;
        this.duration = duration;
        this.entryId = entryId;
        this.type = type;
        this.style = style;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigInteger getTime() {
        return time;
    }

    public void setTime(BigInteger time) {
        this.time = time;
    }

    public BigInteger getDuration() {
        return duration;
    }

    public void setDuration(BigInteger duration) {
        this.duration = duration;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public AnnotationType getType() {
        return type;
    }

    public void setType(AnnotationType type) {
        this.type = type;
    }

    public OutputElementStyle getStyle() {
        return style;
    }

    public void setStyle(OutputElementStyle style) {
        this.style = style;
    }

}
