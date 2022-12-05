package org.eclipse.tsp.java.client.models.query;

import java.math.BigInteger;

public class QueryInterval {
    private BigInteger start;
    private BigInteger end;
    private int nbTimes;

    public QueryInterval() {
    }

    public QueryInterval(BigInteger start, BigInteger end, int nbTimes) {
        this.start = start;
        this.end = end;
        this.nbTimes = nbTimes;
    }

    public QueryInterval(BigInteger start, BigInteger end) {
        this.start = start;
        this.end = end;
        this.nbTimes = 0;
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

    public int getNbTimes() {
        return nbTimes;
    }

    public void setNbTimes(int nbTimes) {
        this.nbTimes = nbTimes;
    }
}
