package org.eclipse.tsp.java.client.api.bookmark;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@NoArgsConstructor
public class Bookmark {

	@EqualsAndHashCode.Include
	@NonNull
	private UUID uuid;
	@NonNull
	private String name;
	@NonNull
	private Long startTime;
	@NonNull
	private Long endTime;
	@NonNull
	private String type;

}
