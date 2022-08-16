package org.eclipse.tsp.java.client.models.timegraph;

import java.math.BigInteger;

import org.eclipse.tsp.java.client.models.style.OutputElementStyle;

public class TimeGraphState {
    private BigInteger start;
    private BigInteger end;
    private String label;
    private int tags;
    private OutputElementStyle style;

    public TimeGraphState(BigInteger start, BigInteger end) {
        this.start = start;
        this.end = end;
    }

    public TimeGraphState(BigInteger start, BigInteger end, String label) {
        this.start = start;
        this.end = end;
        this.label = label;
    }

    public TimeGraphState(BigInteger start, BigInteger end, String label, int tags) {
        this.start = start;
        this.end = end;
        this.label = label;
        this.tags = tags;
    }

    public TimeGraphState(BigInteger start, BigInteger end, String label, int tags, OutputElementStyle style) {
        this.start = start;
        this.end = end;
        this.label = label;
        this.tags = tags;
        this.style = style;
    }

    public BigInteger getStart() {
        return start;
    }

    public void setStart(BigInteger start) {
        this.start = start;
    }

    public BigInteger getEnd() {
        return end;
    }

    public void setEnd(BigInteger end) {
        this.end = end;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getTags() {
        return tags;
    }

    public void setTags(int tags) {
        this.tags = tags;
    }

    public OutputElementStyle getStyle() {
        return style;
    }

    public void setStyle(OutputElementStyle style) {
        this.style = style;
    }
}
