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

    public Annotation(String label, BigInteger time, BigInteger duration, int entryId, String type) {
        this.label = label;
        this.time = time;
        this.duration = duration;
        this.entryId = entryId;
        this.type = type;
        this.style = null;
    }

    public Annotation(String label, BigInteger time, BigInteger duration, int entryId, String type,
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OutputElementStyle getStyle() {
        return style;
    }

    public void setStyle(OutputElementStyle style) {
        this.style = style;
    }

}
