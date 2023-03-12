package org.eclipse.tsp.java.client.annotation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.restclient.RestClient;
import org.eclipse.tsp.java.client.shared.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.tsp.AbstractTspApi;

import com.fasterxml.jackson.core.type.TypeReference;

public class AnnotationApi extends AbstractTspApi {
    private final String ANNOTATION_API_URL = "%s/experiments/%s/outputs/%s/annotations";

    public AnnotationApi(String baseUrl) {
        super(baseUrl);
    }

    public TspClientResponse<GenericResponse<AnnotationCategoriesModel>> getAnnotationsCategories(
            UUID experimentUuid, String outputId, Optional<String> markerSetId) {
        Map<String, String> queryParameters = null;
        if (markerSetId.isPresent()) {
            queryParameters = new HashMap<String, String>();
            queryParameters.put("markserId", markerSetId.get());
        }

        final TspClientResponse<String> tspClientResponse = RestClient.get(
                String.format(this.ANNOTATION_API_URL, this.getBaseUrl(), experimentUuid, outputId),
                markerSetId.isPresent() ? Optional.of(queryParameters) : Optional.empty(), String.class);

        return TspClientResponse.getGenericResponse(tspClientResponse,
                new TypeReference<GenericResponse<AnnotationCategoriesModel>>() {
                });
    }

    public TspClientResponse<GenericResponse<AnnotationModel>> getAnnotations(UUID experimentUuid, String outputId,
            Query query) {

        final TspClientResponse<String> tspClientResponse = RestClient.post(
                String.format(this.ANNOTATION_API_URL, this.getBaseUrl(), experimentUuid, outputId),
                Optional.of(query), String.class);

        return TspClientResponse.getGenericResponse(tspClientResponse,
                new TypeReference<GenericResponse<AnnotationModel>>() {
                });
    }

}
