package org.eclipse.tsp.java.client.models.timegraph;

import java.util.ArrayList;
import java.util.List;

public class TimeGraphModel {
    private List<TimeGraphRow> rows;

    public TimeGraphModel() {
        rows = new ArrayList<>();
    }

    public TimeGraphModel(List<TimeGraphRow> rows) {
        this.rows = rows;
    }

    public List<TimeGraphRow> getRows() {
        return rows;
    }

    public void setRows(List<TimeGraphRow> rows) {
        this.rows = rows;
    }
}
