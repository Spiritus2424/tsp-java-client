package org.eclipse.tsp.java.client.api.timegraph.dto;

import org.eclipse.tsp.java.client.shared.query.TimeRange;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTimeGraphTreeRequestDto {

	@JsonProperty("requested_timerange")
	@NonNull
	@NotNull
	public TimeRange requestedTimerange;
}
