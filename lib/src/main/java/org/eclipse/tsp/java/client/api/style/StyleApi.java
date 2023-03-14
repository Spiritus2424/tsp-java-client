package org.eclipse.tsp.java.client.api.style;

import java.util.Optional;
import java.util.UUID;

import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.core.restclient.RestClient;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;

import com.fasterxml.jackson.core.type.TypeReference;

public class StyleApi extends AbstractTspApi {
    private final String STYLE_API_URL = "%s/experiments/%s/outputs/%s/style";

    public StyleApi(String baseUrl) {
        super(baseUrl);
    }

    public TspClientResponse<GenericResponse<OutputStyleModel>> getStyles(UUID experimentUuid, String outputId,
            Query query) {
        TspClientResponse<String> tspClientResponse = RestClient.post(
                String.format(this.STYLE_API_URL, this.getBaseUrl(), experimentUuid, outputId),
                Optional.of(query), String.class);

        return TspClientResponse.getGenericResponse(tspClientResponse,
                new TypeReference<GenericResponse<OutputStyleModel>>() {
                });
    }
}
