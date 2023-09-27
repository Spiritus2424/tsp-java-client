package org.eclipse.tsp.java.client.api.graph;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CreateCriticalPathDto {
	@NonNull
	private Vertex startVertex;
	@NonNull
	private Vertex endVertex;
}
