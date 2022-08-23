package org.eclipse.tsp.java.client.protocol.restclient;

import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.WireMockServer;

import jakarta.ws.rs.core.MediaType;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;

public class RestClientTest {

    public static WireMockServer wireMockServer = new WireMockServer();

    @BeforeAll
    static void setupAll() {
        wireMockServer.start();
    }

    @AfterAll
    static void tearDownAll() {
        wireMockServer.stop();
    }

    // @DisplayName("Single test successful")
    // @Test
    // void testSingleSuccessTest() {
    // System.out.print("Sucess");

    // }

    // @Test
    // @Disabled("Not implemented yet")
    // void testShowSomething() {
    // }

    @Test
    public void getMethod() {
        stubFor(get("/my/resource")
                .withHeader("Content-Type", containing("json"))
                .willReturn(ok()
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON)
                        .withBody("{}")));

        TspClientResponse<String> result = RestClient.get("/my/resource",
                Optional.empty());
        assertTrue(result.isOk());

        // verify(postRequestedFor(urlPathEqualTo("/my/resource"))
        // .withRequestBody(matching(".*message-1234.*"))
        // .withHeader("Content-Type", equalTo("text/xml")));
    }

    @Test
    public void postMethod() {
        stubFor(post("/my/resource")
                .withHeader("Content-Type", containing("xml"))
                .willReturn(ok()
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>SUCCESS</response>")));

        // TspClientResponse<String> result = RestClient.post("/my/resource",
        // Optional.empty());
        // assertTrue(result.isOk());

        // verify(postRequestedFor(urlPathEqualTo("/my/resource"))
        // .withRequestBody(matching(".*message-1234.*"))
        // .withHeader("Content-Type", equalTo("text/xml")));
    }

    @Test
    public void putMethod() {
        stubFor(post("/my/resource")
                .withHeader("Content-Type", containing("xml"))
                .willReturn(ok()
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>SUCCESS</response>")));

        // TspClientResponse<String> result = RestClient.post("/my/resource",
        // Optional.empty());
        // assertTrue(result.isOk());

        // verify(postRequestedFor(urlPathEqualTo("/my/resource"))
        // .withRequestBody(matching(".*message-1234.*"))
        // .withHeader("Content-Type", equalTo("text/xml")));
    }

    @Test
    public void deleteMethod() {
        stubFor(post("/my/resource")
                .withHeader("Content-Type", containing("xml"))
                .willReturn(ok()
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>SUCCESS</response>")));

        // TspClientResponse<String> result = RestClient.post("/my/resource",
        // Optional.empty());
        // assertTrue(result.isOk());

        // verify(postRequestedFor(urlPathEqualTo("/my/resource"))
        // .withRequestBody(matching(".*message-1234.*"))
        // .withHeader("Content-Type", equalTo("text/xml")));
    }

}
