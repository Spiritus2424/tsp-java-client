package org.eclipse.tsp.java.client.api.graph;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@JsonDeserialize(keyUsing = VertexDeserializer.class)
public class Vertex {
	@NonNull
	private Long timestamp;

	@NonNull
	private Integer workerId;
}
