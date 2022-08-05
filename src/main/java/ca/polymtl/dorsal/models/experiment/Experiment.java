package ca.polymtl.dorsal.models.experiment;

import java.math.BigInteger;
import java.util.ArrayList;

import ca.polymtl.dorsal.models.trace.Trace;

public class Experiment {
    private String uUID;
    private String name;
    private BigInteger start;
    private BigInteger end;
    private int nbEvents;
    private String indexingStatus;
    private ArrayList<Trace> traces;

    public Experiment(String uUID, String name, BigInteger start, BigInteger end, int nbEvents, String indexingStatus,
            ArrayList<Trace> traces) {
        this.uUID = uUID;
        this.name = name;
        this.start = start;
        this.end = end;
        this.nbEvents = nbEvents;
        this.indexingStatus = indexingStatus;
        this.traces = traces;
    }

    public String getUUID() {
        return uUID;
    }

    public void setUUID(String uUID) {
        this.uUID = uUID;
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

    public String getIndexingStatus() {
        return indexingStatus;
    }

    public void setIndexingStatus(String indexingStatus) {
        this.indexingStatus = indexingStatus;
    }

    public ArrayList<Trace> getTraces() {
        return traces;
    }

    public void setTraces(ArrayList<Trace> traces) {
        this.traces = traces;
    }
}
