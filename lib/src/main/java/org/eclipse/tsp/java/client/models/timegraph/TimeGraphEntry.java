package org.eclipse.tsp.java.client.models.timegraph;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.tsp.java.client.models.entry.Entry;
import org.eclipse.tsp.java.client.models.style.OutputElementStyle;

public class TimeGraphEntry extends Entry {
    private BigInteger start;
    private BigInteger end;

    public TimeGraphEntry() {
        super();
    }

    public TimeGraphEntry(BigInteger start, BigInteger end, int id, String[] labels) {
        super(id, labels);
        this.start = start;
        this.end = end;
    }

    public TimeGraphEntry(BigInteger start, BigInteger end, int id, String[] labels, int parentId) {
        super(id, labels, parentId);
        this.start = start;
        this.end = end;
    }

    public TimeGraphEntry(BigInteger start, BigInteger end, int id, String[] labels, int parentId, Boolean hasData) {
        super(id, labels, parentId, hasData);
        this.start = start;
        this.end = end;
    }

    public TimeGraphEntry(BigInteger start, BigInteger end, int id, String[] labels, int parentId, Boolean hasData,
            OutputElementStyle style) {
        super(id, labels, parentId, hasData, style);
        this.start = start;
        this.end = end;
    }

    public TimeGraphEntry(BigInteger start, BigInteger end, int id, String[] labels, int parentId, Boolean hasData,
            OutputElementStyle style,
            Map<String, Object> metadata) {
        super(id, labels, parentId, hasData, style, metadata);
        this.start = start;
        this.end = end;
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
}
