package org.eclipse.tsp.java.client.api.trace;

import java.math.BigInteger;
import java.util.UUID;

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
public class Trace {
	@JsonProperty(value = "UUID", required = true)
	@EqualsAndHashCode.Include
	@NonNull
	private UUID uuid;
	@NonNull
	private String name;
	@NonNull
	private BigInteger start;
	@NonNull
	private BigInteger end;
	@NonNull
	private String path;
	@NonNull
	private Integer nbEvents;
	@NonNull
	private IndexingStatus indexingStatus;

}
