package org.eclipse.tsp.java.client.api.graph;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.query.TimeRange;

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
			Body<TimeRange> body) {
		return this.getRestClientSingleton().post(
				String.format(this.graphApiUrl.concat("/vertexes"), experimentUuid),
				Optional.of(body),
				this.getTypeFactory().constructCollectionType(List.class, Vertex.class));
	}

	@Async
	public TspClientResponse<Map<Vertex, TcpEventKey>> fetchVertexIndexes(
			@PathParam("expUUID") UUID experimentUuid) {

		return this.getRestClientSingleton().post(
				String.format(this.graphApiUrl.concat("/indexes"), experimentUuid),
				Optional.empty(),
				this.getTypeFactory().constructMapType(Map.class, Vertex.class, TcpEventKey.class));
	}

}
