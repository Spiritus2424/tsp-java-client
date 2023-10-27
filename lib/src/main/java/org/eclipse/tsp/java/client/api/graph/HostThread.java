package org.eclipse.tsp.java.client.api.graph;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class HostThread {
	@NonNull
	@JsonProperty("host")
	private String traceHost;

	@NonNull
	@JsonProperty("tid")
	private Integer threadId;
}
