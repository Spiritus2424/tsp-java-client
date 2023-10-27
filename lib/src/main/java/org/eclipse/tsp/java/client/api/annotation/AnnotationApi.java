package org.eclipse.tsp.java.client.api.annotation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.api.annotation.dto.GetAnnotationsRequestDto;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLogBuilder;

public class AnnotationApi extends AbstractTspApi {
	private final @NonNull Logger logger;
	private final String ANNOTATION_API_URL;

	public AnnotationApi(String baseUrl) {
		super(baseUrl);
		this.logger = TraceCompassLog.getLogger(AnnotationApi.class);
		this.ANNOTATION_API_URL = this.getBaseUrl().concat("/experiments/%s/outputs/%s/annotations");
	}

	@Async
	public TspClientResponse<GenericResponse<AnnotationCategoriesModel>> getAnnotationsCategories(
			final UUID experimentUuid,
			final String outputId,
			final Optional<String> markerSetId) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"AnnotationApi#getAnnotationsCategories")
				.setCategory(outputId).build()) {
			Map<String, String> queryParameters = new HashMap<String, String>();
			if (markerSetId.isPresent()) {
				queryParameters.put("markserId", markerSetId.get());
			}

			return this.getRestClientSingleton().get(String.format(this.ANNOTATION_API_URL, experimentUuid, outputId),
					Optional.of(queryParameters),
					this.getTypeFactory().constructParametricType(GenericResponse.class,
							AnnotationCategoriesModel.class));
		}
	}

	@Async
	public TspClientResponse<GenericResponse<AnnotationModel>> getAnnotations(
			final UUID experimentUuid,
			final String outputId,
			final Body<GetAnnotationsRequestDto> body) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"AnnotationApi#getAnnotations")
				.setCategory(outputId).build()) {
			return this.getRestClientSingleton().post(String.format(this.ANNOTATION_API_URL, experimentUuid, outputId),
					Optional.of(body),
					Optional.empty(),
					this.getTypeFactory().constructParametricType(GenericResponse.class, AnnotationModel.class));
		}
	}

}
