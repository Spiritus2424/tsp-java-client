package org.eclipse.tsp.java.client.models.trace;

import java.math.BigInteger;

public class Trace {
    private String uuid;
    private String name;
    private BigInteger start;
    private BigInteger end;
    private String path;
    private int nbEvents;
    private String indexingStatus;

    public Trace(String uuid, String name, BigInteger start, BigInteger end, String path, int nbEvents,
            String indexingStatus) {
        this.uuid = uuid;
        this.name = name;
        this.start = start;
        this.end = end;
        this.path = path;
        this.nbEvents = nbEvents;
        this.indexingStatus = indexingStatus;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getNbEvents() {
        return nbEvents;
    }

    public void setNbEvents(int nbEvents) {
        this.nbEvents = nbEvents;
    }

    public String getIndexingStatus() {
        return indexingStatus;
    }

    public void setIndexingStatus(String indexingStatus) {
        this.indexingStatus = indexingStatus;
    }

}
