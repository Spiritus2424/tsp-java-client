package org.eclipse.tsp.java.client.api.annotation;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpPort = 8080)
@EnabledIfSystemProperty(named = "concurrent", matches = "true")
public class AnnotationApiAsyncTest {

	private static final String FIXTURE_PATH = "fixtures/tspclient";
	private static final String TSP_EXTENSION_URL = "/tsp/api";

	private AnnotationApiAsync annotationApiAsync = new AnnotationApiAsync("http://localhost:8080",
			Executors.newSingleThreadExecutor());
	private AnnotationApi annotationApi = new AnnotationApi("http://localhost:8080");

	@Test
	public void fetchAnnotationCategories() {
		final UUID experimentUuid = UUID.fromString("11111111-1111-1111-1111-111111111111");
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/%s/annotations", TSP_EXTENSION_URL,
				experimentUuid,
				outputId);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-annotation-categories.json", FIXTURE_PATH))));

		final int TOTAL_REQUEST = 100;
		StopWatch syncStopWatch = new StopWatch();
		syncStopWatch.start();
		for (int i = 0; i < TOTAL_REQUEST; i++) {
			this.annotationApi.getAnnotationsCategories(experimentUuid, outputId, Optional.empty());
		}
		syncStopWatch.stop();

		StopWatch asyncStopWatch = new StopWatch();
		asyncStopWatch.start();
		List<CompletableFuture<TspClientResponse<GenericResponse<AnnotationCategoriesModel>>>> futures = new ArrayList<>();
		for (int i = 0; i < TOTAL_REQUEST; i++) {
			futures.add(this.annotationApiAsync.getAnnotationsCategories(experimentUuid, outputId, Optional.empty()));
		}
		CompletableFuture<Void> allFutures = CompletableFuture
				.allOf(futures.toArray(new CompletableFuture[futures.size()]));
		allFutures.join(); // waits until all futures complete
		asyncStopWatch.stop();
		assertTrue(syncStopWatch.getTime(TimeUnit.MICROSECONDS) > asyncStopWatch.getTime(TimeUnit.MICROSECONDS));
	}

	@Test
	public void fetchAnnotationModel() {
		final UUID experimentUuid = UUID.fromString("11111111-1111-1111-1111-111111111111");
		final String outputId = "11111111-1111-1111-1111-111111111111";
		final String targetUrl = String.format("%s/experiments/%s/outputs/%s/annotations", TSP_EXTENSION_URL,
				experimentUuid,
				outputId);
		stubFor(get(targetUrl).willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBodyFile(String.format("%s/fetch-annotation-categories.json", FIXTURE_PATH))));

		final int TOTAL_REQUEST = 100;
		StopWatch syncStopWatch = new StopWatch();
		syncStopWatch.start();
		for (int i = 0; i < TOTAL_REQUEST; i++) {
			this.annotationApi.getAnnotationsCategories(experimentUuid, outputId, Optional.empty());
		}
		syncStopWatch.stop();

		StopWatch asyncStopWatch = new StopWatch();
		asyncStopWatch.start();
		List<CompletableFuture<TspClientResponse<GenericResponse<AnnotationCategoriesModel>>>> futures = new ArrayList<>();
		for (int i = 0; i < TOTAL_REQUEST; i++) {
			futures.add(this.annotationApiAsync.getAnnotationsCategories(experimentUuid, outputId, Optional.empty()));
		}
		CompletableFuture<Void> allFutures = CompletableFuture
				.allOf(futures.toArray(new CompletableFuture[futures.size()]));
		allFutures.join(); // waits until all futures complete
		asyncStopWatch.stop();
		assertTrue(syncStopWatch.getTime(TimeUnit.MICROSECONDS) > asyncStopWatch.getTime(TimeUnit.MICROSECONDS));
	}

}
