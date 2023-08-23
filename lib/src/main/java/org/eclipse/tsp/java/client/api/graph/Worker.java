package org.eclipse.tsp.java.client.api.graph;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Worker {
	@NonNull
	private HostThread hostThread;
	@NonNull
	private Long start;
	@NonNull
	private String threadName;

	@NonNull
	@JsonProperty("status")
	private ProcessStatus processStatus;

	@NonNull
	@JsonProperty("oldStatus")
	private ProcessStatus oldProcessStatus;
}
