package org.eclipse.tsp.java.client.api.timegraph;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.tsp.java.client.api.style.OutputElementStyle;
import org.eclipse.tsp.java.client.api.timegraph.dto.GetTimeGraphArrowsRequestDto;
import org.eclipse.tsp.java.client.api.timegraph.dto.GetTimeGraphStatesRequestDto;
import org.eclipse.tsp.java.client.api.timegraph.dto.GetTimeGraphTooltipsRequestDto;
import org.eclipse.tsp.java.client.api.timegraph.dto.GetTimeGraphTreeRequestDto;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.entry.EntryHeader;
import org.eclipse.tsp.java.client.shared.entry.EntryModel;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.response.ResponseStatus;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class TimeGraphApiTest {
	private static final String FIXTURE_PATH = "fixtures/tspclient/timegraph";
	private static final String TSP_EXTENSION_URL = "/tsp/api";

	private TimeGraphApi timeGraphApi = new TimeGraphApi("http://localhost:8080");

	@Test
	public void fetchTimegraphArrows() {
		final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/timeGraph/%s/arrows", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-timegraph-arrows.json", FIXTURE_PATH))));

		Body<GetTimeGraphArrowsRequestDto> body = new Body<>();
		TspClientResponse<GenericResponse<List<TimeGraphArrow>>> response = this.timeGraphApi.getTimeGraphArrows(
				experimentUuid, outputId, body);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(1, response.getResponseModel().getModel().size());
		assertEquals(new BigInteger("1111111111111111111"), response.getResponseModel().getModel().get(0).getStart());
		assertEquals(OutputElementStyle.class, response.getResponseModel().getModel().get(0).getStyle().getClass());
	}

	@Test
	public void fetchTimegraphStates() {
		final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/timeGraph/%s/states", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-timegraph-states.json", FIXTURE_PATH))));

		Body<GetTimeGraphStatesRequestDto> body = new Body<>();
		TspClientResponse<GenericResponse<TimeGraphModel>> response = this.timeGraphApi.getTimeGraphStates(
				experimentUuid, outputId, body);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(TimeGraphModel.class, response.getResponseModel().getModel().getClass());
		assertEquals(1, response.getResponseModel().getModel().getRows().size());
		assertEquals(TimeGraphRow.class, response.getResponseModel().getModel().getRows().get(0).getClass());
	}

	@Test
	public void fetchTimegraphTooltip() {
		final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/timeGraph/%s/tooltip", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-timegraph-tooltip.json", FIXTURE_PATH))));

		Body<GetTimeGraphTooltipsRequestDto> body = new Body<>();
		TspClientResponse<GenericResponse<Map<String, String>>> response = this.timeGraphApi.getTimeGraphTooltips(
				experimentUuid, outputId, body);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertTrue(response.getResponseModel().getModel() instanceof Map);
		assertEquals("value", response.getResponseModel().getModel().get("key"));
	}

	@Test
	public void fetchTimegraphTree() {
		final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/timeGraph/%s/tree", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-timegraph-tree.json", FIXTURE_PATH))));

		Body<GetTimeGraphTreeRequestDto> body = new Body<>();
		TspClientResponse<GenericResponse<EntryModel<TimeGraphEntry>>> response = this.timeGraphApi.getTimeGraphTree(
				experimentUuid, outputId, body);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(EntryHeader.class, response.getResponseModel().getModel().getHeaders().get(0).getClass());
		assertEquals(TimeGraphEntry.class, response.getResponseModel().getModel().getEntries().get(0).getClass());
	}

}
