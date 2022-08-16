package org.eclipse.tsp.java.client.models.xy;

import java.math.BigInteger;
import java.util.ArrayList;

import org.eclipse.tsp.java.client.models.style.OutputElementStyle;

public class XYSerie {
    private String serieName;
    private int serieId;
    private XYAxis xAxis;
    private XYAxis yAxis;
    private ArrayList<BigInteger> xValues;
    private ArrayList<BigInteger> yValues;
    private ArrayList<Integer> tags;
    private OutputElementStyle style;

    public XYSerie(String serieName, int serieId, XYAxis xAxis, XYAxis yAxis, ArrayList<BigInteger> xValues,
            ArrayList<BigInteger> yValues, OutputElementStyle style) {
        this.serieName = serieName;
        this.serieId = serieId;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.xValues = xValues;
        this.yValues = yValues;
        this.style = style;
    }

    public XYSerie(String serieName, int serieId, XYAxis xAxis, XYAxis yAxis, ArrayList<BigInteger> xValues,
            ArrayList<BigInteger> yValues, OutputElementStyle style, ArrayList<Integer> tags) {
        this.serieName = serieName;
        this.serieId = serieId;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.xValues = xValues;
        this.yValues = yValues;
        this.style = style;
        this.tags = tags;
    }

    public String getSerieName() {
        return serieName;
    }

    public void setSerieName(String serieName) {
        this.serieName = serieName;
    }

    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public XYAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(XYAxis xAxis) {
        this.xAxis = xAxis;
    }

    public XYAxis getyAxis() {
        return yAxis;
    }

    public void setyAxis(XYAxis yAxis) {
        this.yAxis = yAxis;
    }

    public ArrayList<BigInteger> getxValues() {
        return xValues;
    }

    public void setxValues(ArrayList<BigInteger> xValues) {
        this.xValues = xValues;
    }

    public ArrayList<BigInteger> getyValues() {
        return yValues;
    }

    public void setyValues(ArrayList<BigInteger> yValues) {
        this.yValues = yValues;
    }

    public ArrayList<Integer> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Integer> tags) {
        this.tags = tags;
    }

    public OutputElementStyle getStyle() {
        return style;
    }

    public void setStyle(OutputElementStyle style) {
        this.style = style;
    }
}
