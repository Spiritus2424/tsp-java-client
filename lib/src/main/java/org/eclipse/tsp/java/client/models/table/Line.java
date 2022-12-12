package org.eclipse.tsp.java.client.models.table;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private int index;
    private List<Cell> cells;
    private int tags;

    public Line() {
        this.cells = new ArrayList<>();
    }

    public Line(int index, List<Cell> cells) {
        this.index = index;
        this.cells = cells;
    }

    public Line(int index, List<Cell> cells, int tags) {
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

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public int getTags() {
        return tags;
    }

    public void setTags(int tags) {
        this.tags = tags;
    }
}
