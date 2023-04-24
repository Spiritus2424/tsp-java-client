package org.eclipse.tsp.java.client.api.health;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class HealthApiAsyncTest {
	private static final String FIXTURE_PATH = "fixtures/tspclient";
	private static final String TSP_EXTENSION_URL = "/tsp/api";

	private HealthApiAsync healthApiAsync = new HealthApiAsync("http://localhost:8080",
			Executors.newSingleThreadExecutor());

	@Test
	public void fetchCheckHealth() {
		final String targetUrl = String.format("%s/health", TSP_EXTENSION_URL);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withStatus(200)
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-check-health-0.json", FIXTURE_PATH))));

		Health response = this.healthApiAsync.checkHealth()
				.thenApply(result -> result.getResponseModel()).join();

		assertEquals(response.getStatus(), HealthStatus.UP);
	}
}
