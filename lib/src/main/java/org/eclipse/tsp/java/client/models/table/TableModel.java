package org.eclipse.tsp.java.client.models.table;

import java.util.ArrayList;

public class TableModel {
    private int lowIndex;
    private int size;
    private ArrayList<Integer> columnIds;
    private ArrayList<Line> lines;

    public TableModel(int lowIndex, int size, ArrayList<Integer> columnIds, ArrayList<Line> lines) {
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

    public ArrayList<Integer> getColumnIds() {
        return columnIds;
    }

    public void setColumnIds(ArrayList<Integer> columnIds) {
        this.columnIds = columnIds;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }
}
