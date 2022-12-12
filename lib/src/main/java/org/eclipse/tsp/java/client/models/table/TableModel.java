package org.eclipse.tsp.java.client.models.table;

import java.util.ArrayList;
import java.util.List;

public class TableModel {
    private int lowIndex;
    private int size;
    private List<Integer> columnIds;
    private List<Line> lines;

    public TableModel() {
        this.columnIds = new ArrayList<>();
        this.lines = new ArrayList<>();
    }

    public TableModel(int lowIndex, int size, List<Integer> columnIds, List<Line> lines) {
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

    public List<Integer> getColumnIds() {
        return columnIds;
    }

    public void setColumnIds(List<Integer> columnIds) {
        this.columnIds = columnIds;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}
