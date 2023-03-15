package org.eclipse.tsp.java.client.api.xy;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.entry.Entry;
import org.eclipse.tsp.java.client.shared.entry.EntryHeader;
import org.eclipse.tsp.java.client.shared.entry.EntryModel;
import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.response.ResponseStatus;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class XyApiTest {
        private static final String FIXTURE_PATH = "fixtures/tspclient";
        private static final String TSP_EXTENSION_URL = "/tsp/api";

        private XyApi xyApi = new XyApi("http://localhost:8080");

        @Test
        public void fetchXy() {
                final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
                final String outputId = "11111111-1111-1111-1111-111111111111";
                final String targetUrl = String.format("%s/experiments/%s/outputs/XY/%s/xy", TSP_EXTENSION_URL,
                                experimentUuid, outputId);
                stubFor(post(targetUrl).willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBodyFile(String.format("%s/fetch-xy-0.json", FIXTURE_PATH))));

                Map<String, Object> parameters = new HashMap<>();
                Query query = new Query(parameters);
                TspClientResponse<GenericResponse<XyModel>> response = this.xyApi.getXy(
                                experimentUuid, outputId, query);

                assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
                assertEquals(XyModel.class, response.getResponseModel().getModel().getClass());
                assertEquals("Chart name", response.getResponseModel().getModel().getTitle());
                assertEquals(XySerie.class, response.getResponseModel().getModel().getSeries().get(0).getClass());
        }

        @Test
        public void fetchXyTree() {
                final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
                final String outputId = "11111111-1111-1111-1111-111111111111";
                final String targetUrl = String.format("%s/experiments/%s/outputs/XY/%s/tree", TSP_EXTENSION_URL,
                                experimentUuid, outputId);
                stubFor(post(targetUrl).willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBodyFile(String.format("%s/fetch-xy-tree-0.json", FIXTURE_PATH))));

                Map<String, Object> parameters = new HashMap<>();
                Query query = new Query(parameters);
                TspClientResponse<GenericResponse<EntryModel<Entry>>> response = this.xyApi.getXyTree(
                                experimentUuid, outputId, query);

                assertEquals(ResponseStatus.RUNNING, response.getResponseModel().getStatus());
                assertEquals(EntryHeader.class, response.getResponseModel().getModel().getHeaders().get(0).getClass());
                assertEquals(Entry.class, response.getResponseModel().getModel().getEntries().get(0).getClass());
        }

}
