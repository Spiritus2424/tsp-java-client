package org.eclipse.tsp.java.client.models.table;

import java.util.ArrayList;

public class Line {
    private int index;
    private ArrayList<Cell> cells;
    private int tags;

    public Line(int index, ArrayList<Cell> cells) {
        this.index = index;
        this.cells = cells;
    }

    public Line(int index, ArrayList<Cell> cells, int tags) {
        this.index = index;
        this.cells = cells;
        this.tags = tags;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public int getTags() {
        return tags;
    }

    public void setTags(int tags) {
        this.tags = tags;
    }
}
