package org.eclipse.tsp.java.client.models.xy;

import java.math.BigInteger;

import org.eclipse.tsp.java.client.models.style.OutputElementStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class XYSerie {

    @JsonProperty("seriesName")
    private String serieName;
    @JsonProperty("seriesId")
    private int serieId;
    private XYAxis xAxis;
    private XYAxis yAxis;
    private BigInteger[] xValues;
    private BigInteger[] yValues;
    private int[] tags;
    private OutputElementStyle style;

    public XYSerie() {
    }

    public XYSerie(String serieName, int serieId, XYAxis xAxis, XYAxis yAxis, BigInteger[] xValues,
            BigInteger[] yValues, OutputElementStyle style) {
        this.serieName = serieName;
        this.serieId = serieId;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.xValues = xValues;
        this.yValues = yValues;
        this.style = style;
    }

    public XYSerie(String serieName, int serieId, XYAxis xAxis, XYAxis yAxis, BigInteger[] xValues,
            BigInteger[] yValues, OutputElementStyle style, int[] tags) {
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

    public BigInteger[] getxValues() {
        return xValues;
    }

    public void setxValues(BigInteger[] xValues) {
        this.xValues = xValues;
    }

    public BigInteger[] getyValues() {
        return yValues;
    }

    public void setyValues(BigInteger[] yValues) {
        this.yValues = yValues;
    }

    public int[] getTags() {
        return tags;
    }

    public void setTags(int[] tags) {
        this.tags = tags;
    }

    public OutputElementStyle getStyle() {
        return style;
    }

    public void setStyle(OutputElementStyle style) {
        this.style = style;
    }
}
