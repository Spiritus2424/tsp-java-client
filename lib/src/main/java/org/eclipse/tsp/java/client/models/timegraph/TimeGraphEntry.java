package org.eclipse.tsp.java.client.models.timegraph;

import java.math.BigInteger;

public class TimeGraphEntry {
    private BigInteger start;
    private BigInteger end;

    public TimeGraphEntry(BigInteger start, BigInteger end) {
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
