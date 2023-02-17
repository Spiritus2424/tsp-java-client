package org.eclipse.tsp.java.client.models.trace;

import java.math.BigInteger;
import java.util.UUID;

import org.eclipse.tsp.java.client.models.indexing.IndexingStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trace {
    @JsonProperty("UUID")
    private UUID uuid;
    private String name;
    private BigInteger start;
    private BigInteger end;
    private String path;
    private int nbEvents;
    private IndexingStatus indexingStatus;

    public Trace() {
    }

    public Trace(UUID uuid, String name, BigInteger start, BigInteger end, String path, int nbEvents,
            IndexingStatus indexingStatus) {
        this.uuid = uuid;
        this.name = name;
        this.start = start;
        this.end = end;
        this.path = path;
        this.nbEvents = nbEvents;
        this.indexingStatus = indexingStatus;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
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

    public IndexingStatus getIndexingStatus() {
        return indexingStatus;
    }

    public void setIndexingStatus(IndexingStatus indexingStatus) {
        this.indexingStatus = indexingStatus;
    }

}
