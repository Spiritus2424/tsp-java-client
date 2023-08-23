package org.eclipse.tsp.java.client.api.graph;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.query.TimeRange;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class GraphApiTest {
	private static final String FIXTURE_PATH = "fixtures/tspclient/graph";
	private static final String TSP_EXTENSION_URL = "/tsp/api";
	private GraphApi graphApi = new GraphApi("http://localhost:8080");

	@Test
	public void fetchWorker() {
		final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
		final Integer workerId = 0;
		final String targetUrl = String.format("%s/experiments/%s/graph/workers/%s", TSP_EXTENSION_URL, experimentUuid,
				workerId);

		stubFor(get(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-worker.json", FIXTURE_PATH))));

		TspClientResponse<Worker> response = this.graphApi.fetchWorker(experimentUuid, workerId);
		Worker worker = response.getResponseModel();
		assertEquals(634, worker.getHostThread().getThreadId());
		assertEquals("\"aa573eff-7a82-4d29-9a41-9df81fca7502\"", worker.getHostThread().getTraceHost());
		assertEquals(Long.valueOf("1539975458475794576"), worker.getStart());
		assertEquals("irq/130-iwlwifi", worker.getThreadName());
		assertEquals(ProcessStatus.WAIT_BLOCKED, worker.getProcessStatus());
		assertEquals(ProcessStatus.RUN, worker.getOldProcessStatus());
	}

	@Test
	public void fetchUnmatchedVertex() {
		final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
		final String targetUrl = String.format("%s/experiments/%s/graph/vertexes", TSP_EXTENSION_URL, experimentUuid);

		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-vertexes.json", FIXTURE_PATH))));

		Body<TimeRange> body = new Body<>(new TimeRange(0L, 1L));
		TspClientResponse<List<Vertex>> response = this.graphApi.fetchUnmatchedVertex(experimentUuid, body);
		List<Vertex> vertexes = response.getResponseModel();

		assertEquals(2, vertexes.size());
		assertEquals(Vertex.class, vertexes.get(0).getClass());

	}

	@Test
	public void fetchIndexes() {
		final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
		final String targetUrl = String.format("%s/experiments/%s/graph/indexes", TSP_EXTENSION_URL, experimentUuid);

		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-indexes.json", FIXTURE_PATH))));

		TspClientResponse<Map<Vertex, TcpEventKey>> response = this.graphApi.fetchVertexIndexes(experimentUuid);
		Map<Vertex, TcpEventKey> indexes = response.getResponseModel();

		Vertex vertex = new Vertex(1539975461630457575L, 16);
		assertEquals(3, indexes.size());
		assertEquals(TcpEventKey.class, indexes.get(vertex).getClass());

	}
}
