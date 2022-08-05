package ca.polymtl.dorsal.models.xy;

import java.util.ArrayList;

public class XYModel {
    private String title;
    private ArrayList<XYSerie> series;

    public XYModel(String title, ArrayList<XYSerie> series) {
        this.title = title;
        this.series = series;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<XYSerie> getSeries() {
        return series;
    }

    public void setSeries(ArrayList<XYSerie> series) {
        this.series = series;
    }
}
