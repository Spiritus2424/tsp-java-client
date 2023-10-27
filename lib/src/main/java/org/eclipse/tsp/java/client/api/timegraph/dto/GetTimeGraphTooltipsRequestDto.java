package org.eclipse.tsp.java.client.api.timegraph.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class GetTimeGraphTooltipsRequestDto {

	@JsonProperty("requested_element")
	@NonNull
	@NotNull
	private Element requestedElement;

	@JsonProperty("requested_times")
	@NonNull
	@NotNull
	private List<Long> requestedTimes;

	@JsonProperty("requested_items")
	@NonNull
	@NotNull
	private List<Long> requestedItems;

	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor
	@AllArgsConstructor
	public class Element {
		@NonNull
		@NotNull
		private Long time;

		@NonNull
		@NotNull
		private ElementType elementType;

		@NonNull
		@NotNull
		private Long duration;

		private Long entryId;

		private Long destinationId;
	}

	public enum ElementType {
		state, annotation, arrow
	}
}
