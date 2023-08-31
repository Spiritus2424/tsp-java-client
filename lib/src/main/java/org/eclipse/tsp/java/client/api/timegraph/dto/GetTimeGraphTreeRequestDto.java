package org.eclipse.tsp.java.client.api.timegraph.dto;

import java.util.List;

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
	@JsonProperty("requested_times")
	@NonNull
	@NotNull
	private List<Long> requestedTimes;
}
