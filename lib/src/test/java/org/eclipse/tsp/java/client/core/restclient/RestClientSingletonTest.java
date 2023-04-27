package org.eclipse.tsp.java.client.core.restclient;

import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.Optional;

import org.eclipse.tsp.java.client.api.annotation.Annotation;
import org.eclipse.tsp.java.client.api.annotation.AnnotationType;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class RestClientSingletonTest {

	private final String MOCK_RESSOURCE = "/my/resource";
	private final String MOCK_URL = "http://localhost:8080".concat(MOCK_RESSOURCE);

	private final RestClientSingleton restClientSingleton = RestClientSingleton.getInstance();

	@Test
	public void getMethod() {
		stubFor(get(MOCK_RESSOURCE).willReturn(ok()));
		TspClientResponse<String> result = this.restClientSingleton.get(MOCK_URL,
				Optional.empty(),
				this.restClientSingleton.getObjectMapper().getTypeFactory().constructType(String.class));

		assertTrue(result.isOk());

	}

	// @Test
	// public void postMethodOk() {
	// stubFor(post(MOCK_RESSOURCE).willReturn(ok()));
	// TspClientResponse<String> result = this.restClientSingleton.post(MOCK_URL,
	// Optional.empty(),
	// this.restClientSingleton.getObjectMapper().getTypeFactory().constructType(String.class));
	// assertTrue(result.isOk());

	// }

	// @Test
	// public void postMethodNotFound() {
	// stubFor(post(MOCK_RESSOURCE).willReturn(notFound()));
	// TspClientResponse<String> result = this.restClientSingleton.post(MOCK_URL,
	// Optional.empty(),
	// this.restClientSingleton.getObjectMapper().getTypeFactory().constructType(String.class));
	// assertTrue(!result.isOk());
	// assertTrue(result.getStatusCode().getStatusCode() == 404);
	// }

	@Test
	public void putMethod() {
		stubFor(put(MOCK_RESSOURCE).willReturn(ok()));
		Annotation annotation = new Annotation("label", BigInteger.ZERO, BigInteger.ZERO, 0, AnnotationType.CHART,
				null);
		TspClientResponse<Annotation> result = this.restClientSingleton.put(MOCK_URL,
				annotation,
				this.restClientSingleton.getObjectMapper().getTypeFactory().constructType(Annotation.class));
		assertTrue(result.isOk());
	}

	@Test
	public void deleteMethod() {
		stubFor(delete(MOCK_RESSOURCE).willReturn(ok()));
		TspClientResponse<String> result = this.restClientSingleton.delete(MOCK_URL,
				Optional.empty(),
				this.restClientSingleton.getObjectMapper().getTypeFactory().constructType(String.class));
		assertTrue(result.isOk());
	}

}
