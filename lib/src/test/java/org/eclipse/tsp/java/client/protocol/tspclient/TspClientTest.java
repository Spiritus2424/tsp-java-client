package org.eclipse.tsp.java.client.protocol.tspclient;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.tsp.java.client.models.health.Health;
import org.eclipse.tsp.java.client.models.health.HealthStatus;
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
}
