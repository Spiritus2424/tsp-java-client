package org.eclipse.tsp.java.client.models.timegraph;

import java.util.ArrayList;
import java.util.List;

public class TimeGraphRow {
    private int entryId;
    private List<TimeGraphState> states;

    public TimeGraphRow() {
        this.states = new ArrayList<>();
    }

    public TimeGraphRow(int entryId, List<TimeGraphState> states) {
        this.entryId = entryId;
        this.states = states;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (this == object)
            isEquals = true;
        else if (object == null || getClass() != object.getClass())
            isEquals = false;
        else {
            TimeGraphRow timeGraphRow = (TimeGraphRow) object;
            isEquals = this.entryId == timeGraphRow.getEntryId();
        }

        return isEquals;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public List<TimeGraphState> getStates() {
        return states;
    }

    public void setStates(List<TimeGraphState> states) {
        this.states = states;
    }
}
