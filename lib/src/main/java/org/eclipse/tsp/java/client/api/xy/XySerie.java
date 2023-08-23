package org.eclipse.tsp.java.client.api.xy;

import java.util.List;

import org.eclipse.tsp.java.client.api.style.OutputElementStyle;

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
public class XySerie {
	@JsonProperty("seriesName")
	@NonNull
	private String serieName;
	@JsonProperty("seriesId")
	@NonNull
	private Long serieId;
	@JsonProperty("xAxis")
	@NonNull
	private XyAxis xAxis;
	@JsonProperty("yAxis")
	@NonNull
	private XyAxis yAxis;
	@JsonProperty("xValues")
	@NonNull
	private List<Long> xValues;
	@JsonProperty("yValues")
	@NonNull
	private List<Double> yValues;
	@NonNull
	private OutputElementStyle style;

	private List<Integer> tags;

}
