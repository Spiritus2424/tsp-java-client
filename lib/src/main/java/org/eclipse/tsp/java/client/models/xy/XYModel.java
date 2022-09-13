package org.eclipse.tsp.java.client.models.xy;

public class XYModel {
    private String title;
    private XYSerie[] series;

    public XYModel() {
    }

    public XYModel(String title, XYSerie[] series) {
        this.title = title;
        this.series = series;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public XYSerie[] getSeries() {
        return series;
    }

    public void setSeries(XYSerie[] series) {
        this.series = series;
    }
}
