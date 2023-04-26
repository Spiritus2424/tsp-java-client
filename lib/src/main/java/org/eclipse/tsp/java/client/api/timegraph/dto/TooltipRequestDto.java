package org.eclipse.tsp.java.client.api.timegraph.dto;

import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TooltipRequestDto {

	@JsonProperty("requested_element")
	@NonNull
	private Element requestedElement;

	@JsonProperty("requested_times")
	@NonNull
	private List<BigInteger> requestedTimes;

	@JsonProperty("requested_items")
	@NonNull
	private List<Integer> requestedItems;

	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor
	public class Element {
		@NonNull
		private BigInteger time;

		@NonNull
		private ElementType elementType;

		@NonNull
		private BigInteger duration;

		private BigInteger entryId;

		private BigInteger destinationId;
	}

	public enum ElementType {
		STATE, ANNOTATION, ARROW
	}
}
