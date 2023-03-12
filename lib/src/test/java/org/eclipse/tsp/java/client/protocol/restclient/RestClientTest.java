package org.eclipse.tsp.java.client.protocol.restclient;

import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.notFound;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.Optional;

import org.eclipse.tsp.java.client.api.annotation.Annotation;
import org.eclipse.tsp.java.client.api.annotation.AnnotationType;
import org.eclipse.tsp.java.client.shared.restclient.RestClient;
import org.eclipse.tsp.java.client.shared.tspclient.TspClientResponse;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class RestClientTest {

    private static final String MOCK_URL = "/my/resource";

    @Test
    public void getMethod() {
        stubFor(get(MOCK_URL).willReturn(ok()));
        TspClientResponse<String> result = RestClient.get("http://localhost:8080".concat(MOCK_URL),
                Optional.empty(), String.class);

        assertTrue(result.isOk());

    }

    @Test
    public void postMethodOk() {
        stubFor(post(MOCK_URL).willReturn(ok()));
        TspClientResponse<String> result = RestClient.post("http://localhost:8080".concat(MOCK_URL), Optional.empty(),
                String.class);
        assertTrue(result.isOk());

    }

    @Test
    public void postMethodNotFound() {
        stubFor(post(MOCK_URL).willReturn(notFound()));
        TspClientResponse<String> result = RestClient.post("http://localhost:8080".concat(MOCK_URL), Optional.empty(),
                String.class);
        assertTrue(!result.isOk());
        assertTrue(result.getStatusCode().getStatusCode() == 404);
    }

    @Test
    public void putMethod() {
        stubFor(put(MOCK_URL).willReturn(ok()));
        Annotation annotation = new Annotation("label", BigInteger.ZERO, BigInteger.ZERO, 0, AnnotationType.CHART,
                null);
        TspClientResponse<Annotation> result = RestClient.put("http://localhost:8080".concat(MOCK_URL), annotation,
                Annotation.class);
        assertTrue(result.isOk());
    }

    @Test
    public void deleteMethod() {
        stubFor(delete(MOCK_URL).willReturn(ok()));
        TspClientResponse<String> result = RestClient.delete("http://localhost:8080".concat(MOCK_URL), Optional.empty(),
                String.class);
        assertTrue(result.isOk());
    }

}
