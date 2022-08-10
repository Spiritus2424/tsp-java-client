package ca.polymtl.dorsal.models.table;

public class Cell {
    private String content;
    private int tags;

    public Cell(String content) {
        this.content = content;
    }

    public Cell(String content, int tags) {
        this.content = content;
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTags() {
        return tags;
    }

    public void setTags(int tags) {
        this.tags = tags;
    }
}
