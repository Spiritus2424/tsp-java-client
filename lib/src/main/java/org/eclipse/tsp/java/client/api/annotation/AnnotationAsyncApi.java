package org.eclipse.tsp.java.client.api.annotation;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;

import com.jcabi.aspects.Async;
import com.jcabi.aspects.Loggable;

public class AnnotationAsyncApi {
	private AnnotationApi annotationApi;

	public AnnotationAsyncApi(String baseUrl) {
		this.annotationApi = new AnnotationApi(baseUrl);
	}

	@Async
	@Loggable
	public CompletableFuture<TspClientResponse<GenericResponse<AnnotationCategoriesModel>>> getAnnotationsCategories(
			UUID experimentUuid, String outputId, Optional<String> markerSetId) {
		return CompletableFuture
				.supplyAsync(() -> this.annotationApi.getAnnotationsCategories(experimentUuid, outputId, markerSetId));
	}

	@Async
	@Loggable
	public CompletableFuture<TspClientResponse<GenericResponse<AnnotationModel>>> getAnnotations(UUID experimentUuid,
			String outputId,
			Query query) {
		return CompletableFuture.supplyAsync(() -> this.annotationApi.getAnnotations(experimentUuid, outputId, query));
	}

}
