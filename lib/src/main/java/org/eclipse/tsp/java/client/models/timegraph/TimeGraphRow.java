package org.eclipse.tsp.java.client.models.timegraph;

import java.util.ArrayList;

public class TimeGraphRow {
    private int entryId;
    private ArrayList<TimeGraphState> states;

    public TimeGraphRow(int entryId, ArrayList<TimeGraphState> states) {
        this.entryId = entryId;
        this.states = states;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public ArrayList<TimeGraphState> getStates() {
        return states;
    }

    public void setStates(ArrayList<TimeGraphState> states) {
        this.states = states;
    }
}
