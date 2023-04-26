package org.eclipse.tsp.java.client.api.experiment.dto;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateExperimentRequestDto {
	@JsonProperty("expTypeId")
	private String experimentTypeId;

	private List<UpdateTrace> traces;

	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor
	public class UpdateTrace {
		@JsonProperty("traceUUID")
		@NonNull
		private UUID traceUuid;

		@NonNull
		private UpdateTraceAction action = UpdateTraceAction.ADD;

		private Integer timeOffset;
	}

	public enum UpdateTraceAction {
		ADD,
		REMOVE
	}
}
