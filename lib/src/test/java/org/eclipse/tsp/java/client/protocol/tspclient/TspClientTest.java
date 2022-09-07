package org.eclipse.tsp.java.client.protocol.tspclient;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.eclipse.tsp.java.client.models.annotation.Annotation;
import org.eclipse.tsp.java.client.models.annotation.AnnotationCategoriesModel;
import org.eclipse.tsp.java.client.models.annotation.AnnotationModel;
import org.eclipse.tsp.java.client.models.experiment.Experiment;
import org.eclipse.tsp.java.client.models.health.Health;
import org.eclipse.tsp.java.client.models.health.HealthStatus;
import org.eclipse.tsp.java.client.models.outputdescriptor.OutputDescriptor;
import org.eclipse.tsp.java.client.models.query.Query;
import org.eclipse.tsp.java.client.models.response.GenericResponse;
import org.eclipse.tsp.java.client.models.response.ResponseStatus;
import org.eclipse.tsp.java.client.models.trace.Trace;
import org.eclipse.tsp.java.client.protocol.restclient.TspClientResponse;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class TspClientTest {

	private static final String FIXTURE_PATH = "fixtures/tspclient";
	private TspClient tspClient = new TspClient("http://localhost:8080");

	@Test
	public void fetchCheckHealth() {
		stubFor(get("/health").willReturn(aResponse()
				.withStatus(200)
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-check-health-0.json", FIXTURE_PATH))));

		TspClientResponse<Health> response = tspClient.checkHealth();

		assertEquals(response.getResponseModel().getStatus(), HealthStatus.UP);

	}

	@Test
	public void createExperiment() {
		stubFor(post("/experiments").willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/create-experiment-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();

		Query query = new Query(parameters);
		TspClientResponse<Experiment> response = tspClient.createExperiment(query);

		assertEquals("kernel", response.getResponseModel().getName());
		assertEquals("22222222-2222-2222-2222-222222222222", response.getResponseModel().getUuid());
		assertEquals(new BigInteger("1234567890123456789"), response.getResponseModel().getStart());
		assertEquals("COMPLETED", response.getResponseModel().getIndexingStatus());
	}

	@Test
	public void deleteExperiment() {
		final String uuid = "22222222-2222-2222-2222-222222222222";
		stubFor(delete("/experiments/".concat(uuid)).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/delete-experiment-0.json", FIXTURE_PATH))));

		TspClientResponse<Experiment> response = tspClient.deleteExperiment(uuid);

		assertEquals("kernel", response.getResponseModel().getName());
		assertEquals(uuid, response.getResponseModel().getUuid());
		assertEquals("CLOSED", response.getResponseModel().getIndexingStatus());
	}

	@Test
	public void deleteTrace() {
		final String uuid = "11111111-1111-1111-1111-111111111111";
		stubFor(delete("/traces/".concat(uuid)).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/delete-trace-0.json", FIXTURE_PATH))));

		TspClientResponse<Trace> response = tspClient.deleteTrace(uuid, Optional.empty(), Optional.empty());

		assertEquals("kernel", response.getResponseModel().getName());
		assertEquals(uuid, response.getResponseModel().getUuid());
		assertEquals("CLOSED", response.getResponseModel().getIndexingStatus());
	}

	@Test
	public void fetchExperimentOutputs() {
		final String uuid = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("/experiments/%s/outputs", uuid);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-experiment-outputs-0.json", FIXTURE_PATH))));

		TspClientResponse<OutputDescriptor[]> response = tspClient.experimentOutPuts(uuid, Optional.empty());

		assertEquals(4, response.getResponseModel().length);
		assertEquals(OutputDescriptor.class, response.getResponseModel()[0].getClass());
	}

	@Test
	public void fetchAnnotationCategories() throws JsonProcessingException, JsonMappingException {
		final String experimentUuid = "11111111-1111-1111-1111-111111111111";
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("/experiments/%s/outputs/%s/annotations", experimentUuid,
				outputId);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-annotation-categories-0.json", FIXTURE_PATH))));

		TspClientResponse<GenericResponse<AnnotationCategoriesModel>> response = tspClient
				.getAnnotationsCategories(experimentUuid, outputId, Optional.empty());

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(1, response.getResponseModel().getModel().getAnnotationCategories().length);
		assertEquals(AnnotationCategoriesModel.class, response.getResponseModel().getModel().getClass());
	}

	@Test
	public void fetchAnnotationModel() throws JsonProcessingException, JsonMappingException {
		final String experimentUuid = "11111111-1111-1111-1111-111111111111";
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("/experiments/%s/outputs/%s/annotations", experimentUuid,
				outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-annotation-model-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);

		TspClientResponse<GenericResponse<AnnotationModel>> response;

		response = tspClient.getAnnotations(experimentUuid, outputId, query);
		assertEquals(ResponseStatus.RUNNING, response.getResponseModel().getStatus());
		assertEquals(Annotation.class,
				response.getResponseModel().getModel().getAnnotations().get("Annotation category")[0]
						.getClass());
		assertEquals(1, response.getResponseModel().getModel().getAnnotations().get("Annotation category").length);
		assertEquals(new BigInteger("1111111111111111111"),
				response.getResponseModel().getModel().getAnnotations().get("Annotation category")[0]
						.getTime());

	}

}
