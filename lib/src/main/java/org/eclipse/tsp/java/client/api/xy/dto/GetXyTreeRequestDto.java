package org.eclipse.tsp.java.client.api.xy.dto;

import org.eclipse.tsp.java.client.shared.query.TimeRange;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetXyTreeRequestDto {
	@JsonProperty("requested_timerange")
	public TimeRange requestedTimerange;
}
