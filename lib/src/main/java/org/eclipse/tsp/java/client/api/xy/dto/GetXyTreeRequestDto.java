package org.eclipse.tsp.java.client.api.xy.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetXyTreeRequestDto {
	@JsonProperty("requested_times")
	@NotNull
	private List<Long> requestedTimes;
}
