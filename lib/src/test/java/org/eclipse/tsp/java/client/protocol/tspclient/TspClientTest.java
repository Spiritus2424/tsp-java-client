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

import org.eclipse.tsp.java.client.models.annotation.Annotation;
import org.eclipse.tsp.java.client.models.annotation.AnnotationCategoriesModel;
import org.eclipse.tsp.java.client.models.annotation.AnnotationModel;
import org.eclipse.tsp.java.client.models.annotation.AnnotationType;
import org.eclipse.tsp.java.client.models.entry.Entry;
import org.eclipse.tsp.java.client.models.entry.EntryHeader;
import org.eclipse.tsp.java.client.models.entry.EntryModel;
import org.eclipse.tsp.java.client.models.experiment.Experiment;
import org.eclipse.tsp.java.client.models.health.Health;
import org.eclipse.tsp.java.client.models.health.HealthStatus;
import org.eclipse.tsp.java.client.models.indexing.IndexingStatus;
import org.eclipse.tsp.java.client.models.markerset.MarkerSet;
import org.eclipse.tsp.java.client.models.outputdescriptor.OutputDescriptor;
import org.eclipse.tsp.java.client.models.query.Query;
import org.eclipse.tsp.java.client.models.response.GenericResponse;
import org.eclipse.tsp.java.client.models.response.ResponseStatus;
import org.eclipse.tsp.java.client.models.style.OutputElementStyle;
import org.eclipse.tsp.java.client.models.style.OutputStyleModel;
import org.eclipse.tsp.java.client.models.table.ColumnHeaderEntry;
import org.eclipse.tsp.java.client.models.table.TableModel;
import org.eclipse.tsp.java.client.models.timegraph.TimeGraphArrow;
import org.eclipse.tsp.java.client.models.timegraph.TimeGraphEntry;
import org.eclipse.tsp.java.client.models.timegraph.TimeGraphModel;
import org.eclipse.tsp.java.client.models.timegraph.TimeGraphRow;
import org.eclipse.tsp.java.client.models.trace.Trace;
import org.eclipse.tsp.java.client.models.xy.XYModel;
import org.eclipse.tsp.java.client.models.xy.XYSerie;
import org.eclipse.tsp.java.client.protocol.restclient.TspClientResponse;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

import jakarta.ws.rs.core.Response.Status;

@WireMockTest(httpPort = 8080)
public class TspClientTest {

	private static final String FIXTURE_PATH = "fixtures/tspclient";
	private TspClient tspClient = new TspClient("http://localhost:8080");
	private static final String TSP_EXTENSION_URL = "/tsp/api";

	@Test
	public void fetchCheckHealth() {
		final String targetUrl = String.format("%s/health", TSP_EXTENSION_URL);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withStatus(200)
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-check-health-0.json", FIXTURE_PATH))));

		TspClientResponse<Health> response = tspClient.checkHealth();

		assertEquals(response.getResponseModel().getStatus(), HealthStatus.UP);

	}

	@Test
	public void createExperiment() {
		final String targetUrl = String.format("%s/experiments", TSP_EXTENSION_URL);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/create-experiment-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();

		Query query = new Query(parameters);
		TspClientResponse<Experiment> response = tspClient.createExperiment(query);

		assertEquals("kernel", response.getResponseModel().getName());
		assertEquals("22222222-2222-2222-2222-222222222222", response.getResponseModel().getUuid());
		assertEquals(new BigInteger("1234567890123456789"), response.getResponseModel().getStart());
		assertEquals(IndexingStatus.COMPLETED, response.getResponseModel().getIndexingStatus());
	}

	@Test
	public void deleteExperiment() {
		final String uuid = "22222222-2222-2222-2222-222222222222";
		final String targetUrl = String.format("%s/experiments/%s", TSP_EXTENSION_URL, uuid);
		stubFor(delete(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/delete-experiment-0.json", FIXTURE_PATH))));

		TspClientResponse<Experiment> response = tspClient.deleteExperiment(uuid);

		assertEquals("kernel", response.getResponseModel().getName());
		assertEquals(uuid, response.getResponseModel().getUuid());
		assertEquals(IndexingStatus.CLOSED, response.getResponseModel().getIndexingStatus());
	}

	@Test
	public void deleteTrace() {
		final String uuid = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/traces/%s", TSP_EXTENSION_URL, uuid);

		stubFor(delete(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/delete-trace-0.json", FIXTURE_PATH))));

		TspClientResponse<Trace> response = tspClient.deleteTrace(uuid, Optional.empty(), Optional.empty());

		assertEquals("kernel", response.getResponseModel().getName());
		assertEquals(uuid, response.getResponseModel().getUuid());
		assertEquals(IndexingStatus.CLOSED, response.getResponseModel().getIndexingStatus());
	}

	@Test
	public void fetchExperimentOutputs() {
		final String uuid = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs", TSP_EXTENSION_URL, uuid);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-experiment-outputs-0.json", FIXTURE_PATH))));

		TspClientResponse<OutputDescriptor[]> response = tspClient.experimentOutputs(uuid, Optional.empty());

		assertEquals(4, response.getResponseModel().length);
		assertEquals(OutputDescriptor.class, response.getResponseModel()[0].getClass());
	}

	@Test
	public void fetchAnnotationCategories() throws JsonProcessingException, JsonMappingException {
		final String experimentUuid = "11111111-1111-1111-1111-111111111111";
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/%s/annotations", TSP_EXTENSION_URL,
				experimentUuid,
				outputId);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-annotation-categories-0.json", FIXTURE_PATH))));

		TspClientResponse<GenericResponse<AnnotationCategoriesModel>> response = tspClient
				.getAnnotationsCategories(experimentUuid, outputId, Optional.empty());

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(1, response.getResponseModel().getModel().getAnnotationCategories().size());
		assertEquals(AnnotationCategoriesModel.class, response.getResponseModel().getModel().getClass());
	}

	@Test
	public void fetchAnnotationModel() throws JsonProcessingException, JsonMappingException {
		final String experimentUuid = "11111111-1111-1111-1111-111111111111";
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/%s/annotations", TSP_EXTENSION_URL,
				experimentUuid,
				outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-annotation-model-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);

		TspClientResponse<GenericResponse<AnnotationModel>> response = tspClient.getAnnotations(experimentUuid,
				outputId, query);
		assertEquals(ResponseStatus.RUNNING, response.getResponseModel().getStatus());
		assertEquals(Annotation.class,
				response.getResponseModel().getModel().getAnnotations().get("Annotation category").get(0)
						.getClass());
		assertEquals(1, response.getResponseModel().getModel().getAnnotations().get("Annotation category").size());
		assertEquals(new BigInteger("1111111111111111111"),
				response.getResponseModel().getModel().getAnnotations().get("Annotation category").get(0)
						.getTime());
		assertEquals(AnnotationType.CHART,
				response.getResponseModel().getModel().getAnnotations().get("Annotation category").get(0)
						.getType());

	}

	@Test
	public void fetchExperiment() {
		final String experimentUuid = "22222222-2222-2222-2222-222222222222";
		final String targetUrl = String.format("%s/experiments/%s", TSP_EXTENSION_URL, experimentUuid);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-experiment-0.json", FIXTURE_PATH))));

		TspClientResponse<Experiment> response = tspClient.getExperiment(experimentUuid);

		assertEquals("kernel", response.getResponseModel().getName());
		assertEquals(experimentUuid, response.getResponseModel().getUuid());
		assertEquals(new BigInteger("1234567890123456789"), response.getResponseModel().getStart());
		assertEquals(IndexingStatus.COMPLETED, response.getResponseModel().getIndexingStatus());
		assertEquals(1, response.getResponseModel().getTraces().size());
		assertEquals("kernel", response.getResponseModel().getTraces().get(0).getName());
	}

	@Test
	public void fetchMarkerSets() {
		final String experimentUuid = "22222222-2222-2222-2222-222222222222";
		final String targetUrl = String.format("%s/experiments/%s/outputs/markerSets", TSP_EXTENSION_URL,
				experimentUuid);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-marker-sets-0.json", FIXTURE_PATH))));

		TspClientResponse<GenericResponse<MarkerSet[]>> response = tspClient.getMarkerSets(experimentUuid);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(MarkerSet[].class, response.getResponseModel().getModel().getClass());
		assertEquals(1, response.getResponseModel().getModel().length);
		assertEquals("marker.set.id", response.getResponseModel().getModel()[0].getId());
	}

	@Test
	public void fetchStyles() {
		final String experimentUuid = "22222222-2222-2222-2222-222222222222";
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/%s/style", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-styles-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);
		TspClientResponse<GenericResponse<OutputStyleModel>> response = tspClient.getStyles(experimentUuid, outputId,
				query);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(OutputStyleModel.class, response.getResponseModel().getModel().getClass());
		assertEquals(null, response.getResponseModel().getModel().getStyles().get("parentKey"));
	}

	@Test
	public void fetchTableColumns() {
		final String experimentUuid = "22222222-2222-2222-2222-222222222222";
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/table/%s/columns", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-table-columns-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);
		TspClientResponse<GenericResponse<ColumnHeaderEntry[]>> response = tspClient.getTableColumns(experimentUuid,
				outputId, query);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(ColumnHeaderEntry[].class, response.getResponseModel().getModel().getClass());
		assertEquals(3, response.getResponseModel().getModel().length);
	}

	@Test
	public void fetchTableLines() {
		final String experimentUuid = "22222222-2222-2222-2222-222222222222";
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/table/%s/lines", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-table-lines-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);
		TspClientResponse<GenericResponse<TableModel>> response = tspClient.getTableLines(experimentUuid,
				outputId, query);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(TableModel.class, response.getResponseModel().getModel().getClass());
		assertEquals(3, response.getResponseModel().getModel().getColumnIds().size());
		assertEquals(2, response.getResponseModel().getModel().getLines().size());
		assertEquals(0, response.getResponseModel().getModel().getLowIndex());
		assertEquals(999999, response.getResponseModel().getModel().getSize());
	}

	@Test
	public void fetchTimegraphArrows() {
		final String experimentUuid = "22222222-2222-2222-2222-222222222222";
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/timeGraph/%s/arrows", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-timegraph-arrows-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);
		TspClientResponse<GenericResponse<TimeGraphArrow[]>> response = tspClient.getTimeGraphArrows(
				experimentUuid, outputId, query);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(TimeGraphArrow[].class, response.getResponseModel().getModel().getClass());
		assertEquals(1, response.getResponseModel().getModel().length);
		assertEquals(new BigInteger("1111111111111111111"), response.getResponseModel().getModel()[0].getStart());
		assertEquals(OutputElementStyle.class, response.getResponseModel().getModel()[0].getStyle().getClass());
	}

	@Test
	public void fetchTimegraphStates() {
		final String experimentUuid = "22222222-2222-2222-2222-222222222222";
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/timeGraph/%s/states", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-timegraph-states-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);
		TspClientResponse<GenericResponse<TimeGraphModel>> response = tspClient.getTimeGraphStates(
				experimentUuid, outputId, query);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(TimeGraphModel.class, response.getResponseModel().getModel().getClass());
		assertEquals(1, response.getResponseModel().getModel().getRows().size());
		assertEquals(TimeGraphRow.class, response.getResponseModel().getModel().getRows().get(0).getClass());
	}

	@Test
	public void fetchTimegraphTooltip() {
		final String experimentUuid = "22222222-2222-2222-2222-222222222222";
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/timeGraph/%s/tooltip", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-timegraph-tooltip-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);
		TspClientResponse<GenericResponse<Map<String, String>>> response = tspClient.getTimeGraphTooltip(
				experimentUuid, outputId, query);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertTrue(response.getResponseModel().getModel() instanceof Map);
		assertEquals("value", response.getResponseModel().getModel().get("key"));
	}

	@Test
	public void fetchTimegraphTree() {
		final String experimentUuid = "22222222-2222-2222-2222-222222222222";
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/timeGraph/%s/tree", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-timegraph-tree-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);
		TspClientResponse<GenericResponse<EntryModel<TimeGraphEntry>>> response = tspClient.getTimeGraphTree(
				experimentUuid, outputId, query);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(EntryHeader.class, response.getResponseModel().getModel().getHeaders().get(0).getClass());
		assertEquals(TimeGraphEntry.class, response.getResponseModel().getModel().getEntries().get(0).getClass());
	}

	@Test
	public void fetchXY() {
		final String experimentUuid = "22222222-2222-2222-2222-222222222222";
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/XY/%s/xy", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-xy-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);
		TspClientResponse<GenericResponse<XYModel>> response = tspClient.getXY(
				experimentUuid, outputId, query);

		assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
		assertEquals(XYModel.class, response.getResponseModel().getModel().getClass());
		assertEquals("Chart name", response.getResponseModel().getModel().getTitle());
		assertEquals(XYSerie.class, response.getResponseModel().getModel().getSeries().get(0).getClass());
	}

	@Test
	public void fetchXYTree() {
		final String experimentUuid = "22222222-2222-2222-2222-222222222222";
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/XY/%s/tree", TSP_EXTENSION_URL,
				experimentUuid, outputId);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-xy-tree-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);
		TspClientResponse<GenericResponse<EntryModel<Entry>>> response = tspClient.getXYTree(
				experimentUuid, outputId, query);

		assertEquals(ResponseStatus.RUNNING, response.getResponseModel().getStatus());
		assertEquals(EntryHeader.class, response.getResponseModel().getModel().getHeaders().get(0).getClass());
		assertEquals(Entry.class, response.getResponseModel().getModel().getEntries().get(0).getClass());
	}

	@Test
	public void openTrace() {
		final String targetUrl = String.format("%s/traces", TSP_EXTENSION_URL);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/open-trace-0.json", FIXTURE_PATH))));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);
		TspClientResponse<Trace> response = tspClient.openTrace(query);

		assertEquals(IndexingStatus.CLOSED, response.getResponseModel().getIndexingStatus());
		assertEquals("kernel", response.getResponseModel().getName());
		assertEquals("11111111-1111-1111-1111-111111111111", response.getResponseModel().getUuid());
	}

	@Test
	public void openTraceNotFound() {
		final String targetUrl = String.format("%s/traces", TSP_EXTENSION_URL);
		stubFor(post(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/open-trace-1.json", FIXTURE_PATH))
				.withStatus(Status.NOT_FOUND.getStatusCode())));

		Map<String, Object> parameters = new HashMap<>();
		Query query = new Query(parameters);
		TspClientResponse<Trace> response = tspClient.openTrace(query);

		assertEquals(response.getStatusCode(), Status.NOT_FOUND);
	}

}
