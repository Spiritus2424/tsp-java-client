package org.eclipse.tsp.java.client.protocol.tspclient;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.eclipse.tsp.java.client.models.experiment.Experiment;
import org.eclipse.tsp.java.client.models.health.Health;
import org.eclipse.tsp.java.client.models.health.HealthStatus;
import org.eclipse.tsp.java.client.models.query.Query;
import org.eclipse.tsp.java.client.models.trace.Trace;
import org.eclipse.tsp.java.client.protocol.restclient.TspClientResponse;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class TspClientTest {

    private static final String FIXTURE_PATH = "fixtures/tspclient";
    private TspClient tspClient = new TspClient("http://localhost:8080");

    @Test
    public void checkHealth() {
        stubFor(get("/health").willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBodyFile(String.format("%s/check-health-0.json", FIXTURE_PATH))));

        TspClientResponse<Health> response = tspClient.checkHealth();
        assertTrue(response.isOk());
        assertEquals(HealthStatus.UP, response.getResponseModel().getStatus());

    }

    @Test
    public void createExperiment() {
        stubFor(post("/experiments").willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBodyFile(String.format("%s/create-experiment-0.json", FIXTURE_PATH))));

        Map<String, Object> parameters = new HashMap<>();

        Query query = new Query(parameters);
        TspClientResponse<Experiment> response = tspClient.createExperiment(query);
        assertTrue(response.isOk());
        assertEquals(response.getResponseModel().getName(), "kernel");
        assertEquals(response.getResponseModel().getUuid(), "22222222-2222-2222-2222-222222222222");
        assertEquals(response.getResponseModel().getStart(), new BigInteger("1234567890123456789"));
        assertEquals(response.getResponseModel().getIndexingStatus(), "COMPLETED");
    }

    @Test
    public void deleteExperiment() {
        final String uuid = "22222222-2222-2222-2222-222222222222";
        stubFor(delete("/experiments/".concat(uuid)).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBodyFile(String.format("%s/delete-experiment-0.json", FIXTURE_PATH))));

        TspClientResponse<Experiment> response = tspClient.deleteExperiment(uuid);
        assertTrue(response.isOk());
        assertEquals(response.getResponseModel().getName(), "kernel");
        assertEquals(response.getResponseModel().getUuid(), uuid);
        assertEquals(response.getResponseModel().getIndexingStatus(), "CLOSED");
    }

    @Test
    public void deleteTrace() {
        final String uuid = "11111111-1111-1111-1111-111111111111";
        stubFor(delete("/traces/".concat(uuid)).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBodyFile(String.format("%s/delete-trace-0.json", FIXTURE_PATH))));

        TspClientResponse<Trace> response = tspClient.deleteTrace(uuid, Optional.empty(), Optional.empty());
        assertTrue(response.isOk());
        assertEquals(response.getResponseModel().getName(), "kernel");
        assertEquals(response.getResponseModel().getUuid(), uuid);
        assertEquals(response.getResponseModel().getIndexingStatus(), "CLOSED");
    }

}
