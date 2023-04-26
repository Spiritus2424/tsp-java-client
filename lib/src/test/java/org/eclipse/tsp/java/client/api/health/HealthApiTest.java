package org.eclipse.tsp.java.client.api.health;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class HealthApiTest {
	private static final String FIXTURE_PATH = "fixtures/tspclient/health";
	private static final String TSP_EXTENSION_URL = "/tsp/api";

	private HealthApi healthApi = new HealthApi("http://localhost:8080");

	@Test
	public void fetchCheckHealth() {
		final String targetUrl = String.format("%s/health", TSP_EXTENSION_URL);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withStatus(200)
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-check-health.json", FIXTURE_PATH))));

		TspClientResponse<Health> response = this.healthApi.checkHealth();

		assertEquals(response.getResponseModel().getStatus(), HealthStatus.UP);

	}
}
