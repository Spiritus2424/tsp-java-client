package org.eclipse.tsp.java.client.api.timegraph.dto;

import java.util.List;

import org.eclipse.tsp.java.client.shared.query.QueryInterval;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTimeGraphTreeRequestDto {
	@JsonProperty("requested_times")
	private List<Long> requestedTimes;

	@JsonProperty("requested_timerange")
	private QueryInterval requestedTimerange;

}
