package org.eclipse.tsp.java.client.api.annotation.dto;

import java.util.List;

import org.eclipse.tsp.java.client.shared.query.QueryInterval;

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
public class GetAnnotationsRequestDto {

	@JsonProperty("requested_timerange")
	@NonNull
	private QueryInterval requestedTimerange;

	@JsonProperty("requested_items")
	private List<Integer> requestedItems;

	@JsonProperty("requested_marker_set")
	private String requestedMarkerSet;

	@JsonProperty("requested_marker_categories")
	private List<String> requestedMarkerCategories;
}
