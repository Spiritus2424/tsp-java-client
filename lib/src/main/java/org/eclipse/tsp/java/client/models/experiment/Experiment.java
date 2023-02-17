package org.eclipse.tsp.java.client.models.experiment;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.eclipse.tsp.java.client.models.indexing.IndexingStatus;
import org.eclipse.tsp.java.client.models.trace.Trace;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Experiment {
    @JsonProperty("UUID")
    private UUID uuid;
    private String name;
    private BigInteger start;
    private BigInteger end;
    private int nbEvents;
    private IndexingStatus indexingStatus;
    private List<Trace> traces;

    public Experiment() {
        traces = new ArrayList<>();
    }

    public Experiment(UUID uuid, String name, BigInteger start, BigInteger end, int nbEvents,
            IndexingStatus indexingStatus,
            List<Trace> traces) {
        this.uuid = uuid;
        this.name = name;
        this.start = start;
        this.end = end;
        this.nbEvents = nbEvents;
        this.indexingStatus = indexingStatus;
        this.traces = traces;
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

    public List<Trace> getTraces() {
        return traces;
    }

    public void setTraces(List<Trace> traces) {
        this.traces = traces;
    }
}
