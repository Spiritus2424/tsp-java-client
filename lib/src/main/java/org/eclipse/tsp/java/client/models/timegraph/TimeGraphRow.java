package org.eclipse.tsp.java.client.models.timegraph;

public class TimeGraphRow {
    private int entryId;
    private TimeGraphState[] states;

    public TimeGraphRow() {
    }

    public TimeGraphRow(int entryId, TimeGraphState[] states) {
        this.entryId = entryId;
        this.states = states;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public TimeGraphState[] getStates() {
        return states;
    }

    public void setStates(TimeGraphState[] states) {
        this.states = states;
    }
}
