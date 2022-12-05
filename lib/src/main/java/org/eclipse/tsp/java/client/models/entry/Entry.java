package org.eclipse.tsp.java.client.models.entry;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.tsp.java.client.models.style.OutputElementStyle;

public class Entry {
    private int id;
    private String[] labels;
    private int parentId;
    private Boolean hasData;
    private OutputElementStyle style;
    private Map<String, Object> metadata;

    public Entry() {
        this.metadata = new HashMap<>();
    }

    public Entry(int id, String[] labels) {
        this.id = id;
        this.labels = labels;
    }

    public Entry(int id, String[] labels, int parentId) {
        this.id = id;
        this.labels = labels;
        this.parentId = parentId;
    }

    public Entry(int id, String[] labels, int parentId, Boolean hasData) {
        this.id = id;
        this.labels = labels;
        this.parentId = parentId;
        this.hasData = hasData;
    }

    public Entry(int id, String[] labels, int parentId, Boolean hasData, OutputElementStyle style) {
        this.id = id;
        this.labels = labels;
        this.parentId = parentId;
        this.hasData = hasData;
        this.style = style;
    }

    public Entry(int id, String[] labels, int parentId, Boolean hasData, OutputElementStyle style,
            Map<String, Object> metadata) {
        this.id = id;
        this.labels = labels;
        this.parentId = parentId;
        this.hasData = hasData;
        this.style = style;
        this.metadata = metadata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Boolean getHasData() {
        return hasData;
    }

    public void setHasData(Boolean hasData) {
        this.hasData = hasData;
    }

    public OutputElementStyle getStyle() {
        return style;
    }

    public void setStyle(OutputElementStyle style) {
        this.style = style;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
