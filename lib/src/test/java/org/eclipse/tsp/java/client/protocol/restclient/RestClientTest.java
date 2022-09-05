package org.eclipse.tsp.java.client.protocol.restclient;

import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.Optional;

import org.eclipse.tsp.java.client.models.annotation.Annotation;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class RestClientTest {

    @Test
    public void getMethod() {
        stubFor(get("/my/resource").willReturn(ok()));
        TspClientResponse<String> result = RestClient.get("http://localhost:8080/my/resource",
                Optional.empty(), String.class);

        assertTrue(result.isOk());

    }

    @Test
    public void postMethod() {
        stubFor(post("/my/resource").willReturn(ok()));
        TspClientResponse<String> result = RestClient.post("http://localhost:8080/my/resource", Optional.empty());
        assertTrue(result.isOk());

    }

    @Test
    public void putMethod() {
        stubFor(put("/my/resource").willReturn(ok()));
        Annotation annotation = new Annotation("label", BigInteger.ZERO, BigInteger.ZERO, 0, "type");
        TspClientResponse<Annotation> result = RestClient.put("http://localhost:8080/my/resource", annotation);
        assertTrue(result.isOk());
    }

    @Test
    public void deleteMethod() {
        stubFor(delete("/my/resource").willReturn(ok()));
        TspClientResponse<String> result = RestClient.delete("http://localhost:8080/my/resource", Optional.empty());
        assertTrue(result.isOk());
    }

}
