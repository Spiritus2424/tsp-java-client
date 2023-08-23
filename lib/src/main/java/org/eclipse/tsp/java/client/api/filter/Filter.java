package org.eclipse.tsp.java.client.api.filter;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Filter {
	@NonNull
	private String id;
	@NonNull
	private String name;
	@NonNull
	private Long startTime;
	@NonNull
	private Long endTime;
	@NonNull
	private String expression;
	@NonNull
	private Integer tags;

}
