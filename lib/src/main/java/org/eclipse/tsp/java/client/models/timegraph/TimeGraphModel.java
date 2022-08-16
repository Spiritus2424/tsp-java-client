package ca.polymtl.dorsal.models.timegraph;

public class TimeGraphModel {
    private TimeGraphRow rows;

    public TimeGraphModel(TimeGraphRow rows) {
        this.rows = rows;
    }

    public TimeGraphRow getRows() {
        return rows;
    }

    public void setRows(TimeGraphRow rows) {
        this.rows = rows;
    }
}
