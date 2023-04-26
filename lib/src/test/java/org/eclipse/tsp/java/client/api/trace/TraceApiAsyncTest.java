package org.eclipse.tsp.java.client.api.trace;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;
import java.util.concurrent.Executors;

import org.eclipse.tsp.java.client.api.trace.dto.OpenTraceRequestDto;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.indexing.IndexingStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
@EnabledIfSystemProperty(named = "concurrent", matches = "true")
public class TraceApiAsyncTest {

	private static final String FIXTURE_PATH = "fixtures/tspclient/trace";
	private static final String TSP_EXTENSION_URL = "/tsp/api";

	private TraceApiAsync traceApiAsync = new TraceApiAsync("http://localhost:8080",
			Executors.newSingleThreadExecutor());

	@Test
	public void openTrace() {
		final String targetUrl = String.format("%s/traces", TSP_EXTENSION_URL);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/open-trace.json", FIXTURE_PATH))));

		OpenTraceRequestDto body = new OpenTraceRequestDto("traceUri");
		TspClientResponse<Trace> response = this.traceApiAsync.openTrace(body).join();

		assertEquals(IndexingStatus.CLOSED,
				response.getResponseModel().getIndexingStatus());
		assertEquals("kernel", response.getResponseModel().getName());
		assertEquals(UUID.fromString("11111111-1111-1111-1111-111111111111"),
				response.getResponseModel().getUuid());
	}

}
