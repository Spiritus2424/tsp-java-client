package org.eclipse.tsp.java.client.api.experiment;

import java.util.List;
import java.util.UUID;

import org.eclipse.tsp.java.client.api.trace.Trace;
import org.eclipse.tsp.java.client.shared.indexing.IndexingStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@NoArgsConstructor
public class Experiment {
	@JsonProperty("UUID")
	@EqualsAndHashCode.Include
	@NonNull
	private UUID uuid;
	@NonNull
	private String name;
	@NonNull
	private Long start;
	@NonNull
	private Long end;
	@NonNull
	private Long nbEvents;
	@NonNull
	private IndexingStatus indexingStatus;
	@NonNull
	private List<Trace> traces;

}
