package org.eclipse.tsp.java.client.xy;

import java.math.BigInteger;
import java.util.List;

import org.eclipse.tsp.java.client.style.OutputElementStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class XYSerie {
    @JsonProperty("seriesName")
    @NonNull
    private String serieName;
    @JsonProperty("seriesId")
    @NonNull
    private int serieId;
    @JsonProperty("xAxis")
    @NonNull
    private XYAxis xAxis;
    @JsonProperty("yAxis")
    @NonNull
    private XYAxis yAxis;
    @JsonProperty("xValues")
    @NonNull
    private List<BigInteger> xValues;
    @JsonProperty("yValues")
    @NonNull
    private List<Double> yValues;
    @NonNull
    private OutputElementStyle style;

    private List<Integer> tags;

}
