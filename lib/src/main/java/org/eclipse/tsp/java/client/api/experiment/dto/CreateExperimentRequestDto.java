package org.eclipse.tsp.java.client.api.experiment.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CreateExperimentRequestDto {
	@JsonProperty("name")
	@NonNull
	private String experimentName;
	@NonNull
	private List<String> traces;
}
