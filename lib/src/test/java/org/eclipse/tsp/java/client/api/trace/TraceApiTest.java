package org.eclipse.tsp.java.client.api.trace;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.indexing.IndexingStatus;
import org.eclipse.tsp.java.client.shared.query.Query;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

import jakarta.ws.rs.core.Response.Status;

@WireMockTest(httpPort = 8080)
public class TraceApiTest {
    private static final String FIXTURE_PATH = "fixtures/tspclient";
    private static final String TSP_EXTENSION_URL = "/tsp/api";

    private TraceApi traceApi = new TraceApi("http://localhost:8080");

    @Test
    public void openTrace() {
        final String targetUrl = String.format("%s/traces", TSP_EXTENSION_URL);
        stubFor(post(targetUrl).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBodyFile(String.format("%s/open-trace-0.json", FIXTURE_PATH))));

        Map<String, Object> parameters = new HashMap<>();
        Query query = new Query(parameters);
        TspClientResponse<Trace> response = this.traceApi.openTrace(query);

        assertEquals(IndexingStatus.CLOSED, response.getResponseModel().getIndexingStatus());
        assertEquals("kernel", response.getResponseModel().getName());
        assertEquals(UUID.fromString("11111111-1111-1111-1111-111111111111"), response.getResponseModel().getUuid());
    }

    @Test
    public void openTraceNotFound() {
        final String targetUrl = String.format("%s/traces", TSP_EXTENSION_URL);
        stubFor(post(targetUrl).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBodyFile(String.format("%s/open-trace-1.json", FIXTURE_PATH))
                .withStatus(Status.NOT_FOUND.getStatusCode())));

        Map<String, Object> parameters = new HashMap<>();
        Query query = new Query(parameters);
        TspClientResponse<Trace> response = this.traceApi.openTrace(query);

        assertEquals(response.getStatusCode(), Status.NOT_FOUND);
    }

    @Test
    public void deleteTrace() {
        final UUID uuid = UUID.fromString("11111111-1111-1111-1111-111111111111");
        final String targetUrl = String.format("%s/traces/%s", TSP_EXTENSION_URL, uuid);

        stubFor(delete(targetUrl).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBodyFile(String.format("%s/delete-trace-0.json", FIXTURE_PATH))));

        TspClientResponse<Trace> response = this.traceApi.deleteTrace(uuid, Optional.empty(), Optional.empty());

        assertEquals("kernel", response.getResponseModel().getName());
        assertEquals(uuid, response.getResponseModel().getUuid());
        assertEquals(IndexingStatus.CLOSED, response.getResponseModel().getIndexingStatus());
    }
}
