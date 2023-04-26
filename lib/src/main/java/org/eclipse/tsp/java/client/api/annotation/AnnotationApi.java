package org.eclipse.tsp.java.client.api.annotation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.api.annotation.dto.GetAnnotationsRequestDto;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;

public class AnnotationApi extends AbstractTspApi {
	private final String ANNOTATION_API_URL;

	public AnnotationApi(String baseUrl) {
		super(baseUrl);
		this.ANNOTATION_API_URL = this.getBaseUrl().concat("/experiments/%s/outputs/%s/annotations");
	}

	@Async
	public TspClientResponse<GenericResponse<AnnotationCategoriesModel>> getAnnotationsCategories(
			final UUID experimentUuid,
			final String outputId,
			final Optional<String> markerSetId) {
		Map<String, String> queryParameters = null;
		if (markerSetId.isPresent()) {
			queryParameters = new HashMap<String, String>();
			queryParameters.put("markserId", markerSetId.get());
		}

		return this.getRestClientSingleton().get(String.format(this.ANNOTATION_API_URL, experimentUuid, outputId),
				markerSetId.isPresent() ? Optional.of(queryParameters) : Optional.empty(),
				this.getTypeFactory().constructParametricType(GenericResponse.class,
						AnnotationCategoriesModel.class));
	}

	@Async
	public TspClientResponse<GenericResponse<AnnotationModel>> getAnnotations(
			final UUID experimentUuid,
			final String outputId,
			final Body<GetAnnotationsRequestDto> body) {
		return this.getRestClientSingleton().post(String.format(this.ANNOTATION_API_URL, experimentUuid, outputId),
				Optional.of(body),
				this.getTypeFactory().constructParametricType(GenericResponse.class, AnnotationModel.class));
	}
}
