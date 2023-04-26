package org.eclipse.tsp.java.client.api.experiment;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.indexing.IndexingStatus;
import org.eclipse.tsp.java.client.shared.query.Query;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class ExperimentApiTest {

	private static final String FIXTURE_PATH = "fixtures/tspclient/experiment";
	private static final String TSP_EXTENSION_URL = "/tsp/api";

	private ExperimentApi experimentApi = new ExperimentApi("http://localhost:8080");

	@Test
	public void createExperiment() {
		final String targetUrl = String.format("%s/experiments", TSP_EXTENSION_URL);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/create-experiment.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();

		Query query = new Query(parameters);
		TspClientResponse<Experiment> response = this.experimentApi.createExperiment(query);

		assertEquals("kernel", response.getResponseModel().getName());
		assertEquals(UUID.fromString("22222222-2222-2222-2222-222222222222"), response.getResponseModel().getUuid());
		assertEquals(new BigInteger("1234567890123456789"), response.getResponseModel().getStart());
		assertEquals(IndexingStatus.COMPLETED, response.getResponseModel().getIndexingStatus());
	}

	@Test
	public void fetchExperiment() {
		final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
		final String targetUrl = String.format("%s/experiments/%s", TSP_EXTENSION_URL, experimentUuid);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-experiment.json", FIXTURE_PATH))));

		TspClientResponse<Experiment> response = this.experimentApi.getExperiment(experimentUuid);

		assertEquals("kernel", response.getResponseModel().getName());
		assertEquals(experimentUuid, response.getResponseModel().getUuid());
		assertEquals(new BigInteger("1234567890123456789"), response.getResponseModel().getStart());
		assertEquals(IndexingStatus.COMPLETED, response.getResponseModel().getIndexingStatus());
		assertEquals(1, response.getResponseModel().getTraces().size());
		assertEquals("kernel", response.getResponseModel().getTraces().get(0).getName());
	}

	@Test
	public void deleteExperiment() {
		final UUID uuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
		final String targetUrl = String.format("%s/experiments/%s", TSP_EXTENSION_URL, uuid);
		stubFor(delete(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/delete-experiment.json", FIXTURE_PATH))));

		TspClientResponse<Experiment> response = this.experimentApi.deleteExperiment(uuid);

		assertEquals("kernel", response.getResponseModel().getName());
		assertEquals(uuid, response.getResponseModel().getUuid());
		assertEquals(IndexingStatus.CLOSED, response.getResponseModel().getIndexingStatus());
	}

}
