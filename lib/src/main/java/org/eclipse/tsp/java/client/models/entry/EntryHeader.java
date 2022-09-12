package org.eclipse.tsp.java.client.models.entry;

public class EntryHeader {
    private String name;
    private String tooltip;

    public EntryHeader() {
    }

    public EntryHeader(String name, String tooltip) {
        this.name = name;
        this.tooltip = tooltip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }
}
