package org.eclipse.tsp.java.client.models.table;

public class TableModel {
    private int lowIndex;
    private int size;
    private int[] columnIds;
    private Line[] lines;

    public TableModel() {
    }

    public TableModel(int lowIndex, int size, int[] columnIds, Line[] lines) {
        this.lowIndex = lowIndex;
        this.size = size;
        this.columnIds = columnIds;
        this.lines = lines;
    }

    public int getLowIndex() {
        return lowIndex;
    }

    public void setLowIndex(int lowIndex) {
        this.lowIndex = lowIndex;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getColumnIds() {
        return columnIds;
    }

    public void setColumnIds(int[] columnIds) {
        this.columnIds = columnIds;
    }

    public Line[] getLines() {
        return lines;
    }

    public void setLines(Line[] lines) {
        this.lines = lines;
    }
}
