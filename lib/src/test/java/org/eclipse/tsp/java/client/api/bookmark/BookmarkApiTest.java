package org.eclipse.tsp.java.client.api.bookmark;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
public class BookmarkApiTest {

	private static final String FIXTURE_PATH = "fixtures/tspclient/bookmark";
	private static final String TSP_EXTENSION_URL = "/tsp/api";

	private BookmarkApi bookmarkApi = new BookmarkApi("http://localhost:8080");

}
