package org.eclipse.tsp.java.client.api.style;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.response.ResponseStatus;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class StyleApiTest {

    private static final String FIXTURE_PATH = "fixtures/tspclient";
    private static final String TSP_EXTENSION_URL = "/tsp/api";

    private StyleApi styleApi = new StyleApi("http://localhost:8080");

    @Test
    public void fetchStyles() {
        final UUID experimentUuid = UUID.fromString("22222222-2222-2222-2222-222222222222");
        final String outputId = "11111111-1111-1111-1111-111111111111";
        final String targetUrl = String.format("%s/experiments/%s/outputs/%s/style", TSP_EXTENSION_URL,
                experimentUuid, outputId);
        stubFor(post(targetUrl).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBodyFile(String.format("%s/fetch-styles-0.json", FIXTURE_PATH))));

        Map<String, Object> parameters = new HashMap<>();
        Query query = new Query(parameters);
        TspClientResponse<GenericResponse<OutputStyleModel>> response = this.styleApi.getStyles(experimentUuid,
                outputId,
                query);

        assertEquals(ResponseStatus.COMPLETED, response.getResponseModel().getStatus());
        assertEquals(OutputStyleModel.class, response.getResponseModel().getModel().getClass());
        assertEquals(null, response.getResponseModel().getModel().getStyles().get("parentKey"));
    }

}
