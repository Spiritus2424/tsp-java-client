package org.eclipse.tsp.java.client.models.xy;

import java.util.ArrayList;
import java.util.List;

public class XYModel {
    private String title;
    private List<XYSerie> series;

    public XYModel() {
        this.series = new ArrayList<>();
    }

    public XYModel(String title, List<XYSerie> series) {
        this.title = title;
        this.series = series;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<XYSerie> getSeries() {
        return series;
    }

    public void setSeries(List<XYSerie> series) {
        this.series = series;
    }
}
