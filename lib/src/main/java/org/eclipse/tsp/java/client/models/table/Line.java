package org.eclipse.tsp.java.client.models.table;

public class Line {
    private int index;
    private Cell[] cells;
    private int tags;

    public Line() {
    }

    public Line(int index, Cell[] cells) {
        this.index = index;
        this.cells = cells;
    }

    public Line(int index, Cell[] cells, int tags) {
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

    public Cell[] getCells() {
        return cells;
    }

    public void setCells(Cell[] cells) {
        this.cells = cells;
    }

    public int getTags() {
        return tags;
    }

    public void setTags(int tags) {
        this.tags = tags;
    }
}
