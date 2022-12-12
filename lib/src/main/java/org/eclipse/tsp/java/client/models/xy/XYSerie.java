package org.eclipse.tsp.java.client.models.xy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.tsp.java.client.models.style.OutputElementStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class XYSerie {

    @JsonProperty("seriesName")
    private String serieName;
    @JsonProperty("seriesId")
    private int serieId;
    private XYAxis xAxis;
    private XYAxis yAxis;
    private List<BigInteger> xValues;
    private List<BigInteger> yValues;
    private List<Integer> tags;
    private OutputElementStyle style;

    public XYSerie() {
        this.xValues = new ArrayList<>();
        this.yValues = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public XYSerie(String serieName, int serieId, XYAxis xAxis, XYAxis yAxis, List<BigInteger> xValues,
            List<BigInteger> yValues, OutputElementStyle style) {
        this.serieName = serieName;
        this.serieId = serieId;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.xValues = xValues;
        this.yValues = yValues;
        this.style = style;
    }

    public XYSerie(String serieName, int serieId, XYAxis xAxis, XYAxis yAxis, List<BigInteger> xValues,
            List<BigInteger> yValues, OutputElementStyle style, List<Integer> tags) {
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

    public List<BigInteger> getxValues() {
        return xValues;
    }

    public void setxValues(List<BigInteger> xValues) {
        this.xValues = xValues;
    }

    public List<BigInteger> getyValues() {
        return yValues;
    }

    public void setyValues(List<BigInteger> yValues) {
        this.yValues = yValues;
    }

    public List<Integer> getTags() {
        return tags;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }

    public OutputElementStyle getStyle() {
        return style;
    }

    public void setStyle(OutputElementStyle style) {
        this.style = style;
    }
}
