package org.eclipse.tsp.java.client.api.filter;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class FilterApiTest {
	private static final String FIXTURE_PATH = "fixtures/tspclient/filter";
	private static final String TSP_EXTENSION_URL = "/tsp/api";

	private FilterApi filterApi = new FilterApi("http://localhost:8080");

}
