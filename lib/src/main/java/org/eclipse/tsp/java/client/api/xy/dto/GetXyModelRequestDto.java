package org.eclipse.tsp.java.client.api.xy.dto;

import java.util.List;

import org.eclipse.tsp.java.client.shared.query.QueryInterval;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class GetXyModelRequestDto {

	@JsonProperty("requested_timerange")
	@NonNull
	@NotNull
	private QueryInterval requestedTimerange;

	@JsonProperty("requested_items")
	@NonNull
	@NotNull
	private List<Long> requestedItems;
}
