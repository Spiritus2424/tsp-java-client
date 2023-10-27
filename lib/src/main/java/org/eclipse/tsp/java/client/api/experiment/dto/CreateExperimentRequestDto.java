package org.eclipse.tsp.java.client.api.experiment.dto;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
	@NotBlank
	private String experimentName;
	@NonNull
	@NotEmpty
	private List<UUID> traces;

}
