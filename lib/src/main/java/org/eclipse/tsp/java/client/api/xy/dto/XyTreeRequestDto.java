package org.eclipse.tsp.java.client.api.xy.dto;

import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class XyTreeRequestDto {

	@JsonProperty("requested_times")
	private List<BigInteger> requestedTimes;
}
