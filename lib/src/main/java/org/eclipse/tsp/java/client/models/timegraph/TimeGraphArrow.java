package org.eclipse.tsp.java.client.models.timegraph;

import java.math.BigInteger;

import org.eclipse.tsp.java.client.models.style.OutputElementStyle;

public class TimeGraphArrow {
    private int sourceId;
    private int targetId;
    private BigInteger start;
    private BigInteger end;
    private OutputElementStyle style;

    public TimeGraphArrow(int sourceId, int targetId, BigInteger start, BigInteger end) {
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.start = start;
        this.end = end;
    }

    public TimeGraphArrow(int sourceId, int targetId, BigInteger start, BigInteger end, OutputElementStyle style) {
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.start = start;
        this.end = end;
        this.style = style;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
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

    public OutputElementStyle getStyle() {
        return style;
    }

    public void setStyle(OutputElementStyle style) {
        this.style = style;
    }
}
