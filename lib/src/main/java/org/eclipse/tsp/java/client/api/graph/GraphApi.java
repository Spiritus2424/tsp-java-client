package org.eclipse.tsp.java.client.api.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.query.TimeRange;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

public class GraphApi extends AbstractTspApi {
	private final String graphApiUrl;

	public GraphApi(String baseUrl) {
		super(baseUrl);
		this.graphApiUrl = this.getBaseUrl().concat("/experiments/%s/graph");
	}

	@Async
	public TspClientResponse<Worker> fetchWorker(UUID experimentUuid, Integer workerId) {
		return this.getRestClientSingleton().get(
				String.format(this.graphApiUrl.concat("/workers/%s"), experimentUuid, workerId),
				Optional.empty(),
				this.getTypeFactory().constructType(Worker.class));
	}

	@Async
	public TspClientResponse<List<Vertex>> fetchUnmatchedVertex(@PathParam("expUUID") UUID experimentUuid,
			Body<TimeRange> body, Optional<Direction> optionalDirection) {

		Map<String, String> queryParams = new HashMap<>();
		if (optionalDirection.isPresent()) {
			queryParams.put("direction", optionalDirection.get().name());
		}
		return this.getRestClientSingleton().post(
				String.format(this.graphApiUrl.concat("/vertexes"), experimentUuid),
				Optional.of(body),
				Optional.of(queryParams),
				this.getTypeFactory().constructCollectionType(List.class, Vertex.class));
	}

	@Async
	public TspClientResponse<Map<Vertex, TcpEventKey>> fetchVertexIndexes(
			UUID experimentUuid, Optional<Direction> optionalDirection) {

		Map<String, String> queryParams = new HashMap<>();
		if (optionalDirection.isPresent()) {
			queryParams.put("direction", optionalDirection.get().name());
		}
		return this.getRestClientSingleton().get(
				String.format(this.graphApiUrl.concat("/indexes"), experimentUuid),
				Optional.of(queryParams),
				this.getTypeFactory().constructMapType(Map.class, Vertex.class, TcpEventKey.class));
	}

	@Path("critical-path")
	@POST
	@Async
	public TspClientResponse<GraphDto> createCriticalPath(@PathParam("expUUID") UUID experimentUuid,
			Body<CreateCriticalPathDto> body) {
		return this.getRestClientSingleton().post(
				String.format(this.graphApiUrl.concat("/critical-path"), experimentUuid),
				Optional.of(body),
				Optional.empty(),
				this.getTypeFactory().constructType(GraphDto.class));
	}
}
