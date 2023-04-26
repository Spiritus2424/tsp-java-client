package org.eclipse.tsp.java.client.api.markerset;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.response.ResponseStatus;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class MarkerSetApiTest {
	private static final String FIXTURE_PATH = "fixtures/tspclient/markerset";
	private static final String TSP_EXTENSION_URL = "/tsp/api";

	private MarkerSetApi markerSetApi = new MarkerSetApi("http://localhost:8080");

	@Test
	public void fetchMarkerSets() {
		final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
		final String targetUrl = String.format("%s/experiments/%s/outputs/markerSets", TSP_EXTENSION_URL,
				experimentUuid);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-marker-sets.json", FIXTURE_PATH))));

		TspClientResponse<GenericResponse<Set<MarkerSet>>> response = this.markerSetApi.getMarkerSets(experimentUuid);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(1, response.getResponseModel().getModel().size());

		assertEquals("marker.set.id", new ArrayList<MarkerSet>(response.getResponseModel().getModel()).get(0).getId());
	}
}
