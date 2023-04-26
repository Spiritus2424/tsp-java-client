package org.eclipse.tsp.java.client.api.outputdescriptor;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class OutputDescriptorApiTest {

	private static final String FIXTURE_PATH = "fixtures/tspclient/outputdescriptor";
	private static final String TSP_EXTENSION_URL = "/tsp/api";

	private OutputDescriptorApi outputDescriptorApi = new OutputDescriptorApi("http://localhost:8080");

	@Test
	public void fetchExperimentOutputs() {
		final UUID uuid = UUID.fromString("11111111-1111-1111-1111-111111111111");
		final String targetUrl = String.format("%s/experiments/%s/outputs", TSP_EXTENSION_URL, uuid);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-output-descriptor.json", FIXTURE_PATH))));

		TspClientResponse<List<OutputDescriptor>> response = this.outputDescriptorApi.experimentOutputs(uuid,
				Optional.empty());

		assertEquals(4, response.getResponseModel().size());
		assertEquals(OutputDescriptor.class, response.getResponseModel().get(0).getClass());
	}
}
