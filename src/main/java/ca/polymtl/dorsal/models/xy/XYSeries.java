package ca.polymtl.dorsal.models.xy;

import java.math.BigInteger;
import java.util.ArrayList;

import ca.polymtl.dorsal.models.style.OutputElementStyle;

public class XYSeries {
    private String seriesName;
    private int seriesId;
    private XYAxis xAxis;
    private XYAxis yAxis;
    private ArrayList<BigInteger> xValues;
    private ArrayList<BigInteger> yValues;
    private ArrayList<Integer> tags;
    private OutputElementStyle style;
}
