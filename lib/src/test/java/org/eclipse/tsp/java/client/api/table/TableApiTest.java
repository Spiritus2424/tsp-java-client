package org.eclipse.tsp.java.client.api.table;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.tsp.java.client.api.table.dto.TableLineRequestDto;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.response.ResponseStatus;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class TableApiTest {
	private static final String FIXTURE_PATH = "fixtures/tspclient/table";
	private static final String TSP_EXTENSION_URL = "/tsp/api";

	private TableApi tableApi = new TableApi("http://localhost:8080");

	@Test
	public void fetchTableColumns() {
		final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/table/%s/columns", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-table-columns.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);
		TspClientResponse<GenericResponse<List<ColumnHeaderEntry>>> response = this.tableApi.getTableColumns(
				experimentUuid,
				outputId, query);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(3, response.getResponseModel().getModel().size());
	}

	@Test
	public void fetchTableLines() {
		final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/table/%s/lines", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-table-lines.json", FIXTURE_PATH))));

		Body<TableLineRequestDto> body = new Body<>();
		TspClientResponse<GenericResponse<TableModel>> response = this.tableApi.getTableLines(experimentUuid,
				outputId, body);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(TableModel.class, response.getResponseModel().getModel().getClass());
		assertEquals(3, response.getResponseModel().getModel().getColumnIds().size());
		assertEquals(2, response.getResponseModel().getModel().getLines().size());
		assertEquals(0, response.getResponseModel().getModel().getLowIndex());
		assertEquals(999999, response.getResponseModel().getModel().getSize());
	}

}
