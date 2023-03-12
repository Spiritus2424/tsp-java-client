package org.eclipse.tsp.java.client.markerset;

import java.util.Optional;
import java.util.UUID;

import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.restclient.RestClient;
import org.eclipse.tsp.java.client.shared.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.tspapi.AbstractTspApi;

import com.fasterxml.jackson.core.type.TypeReference;

public class MarkerSetApi extends AbstractTspApi {
    private final String MARKER_SET_API_URL = "%s/experiments/%s/outputs/markerSets";

    public MarkerSetApi(String baseUrl) {
        super(baseUrl);
    }

    public TspClientResponse<GenericResponse<MarkerSet[]>> getMarkerSets(UUID experimentUuid) {
        final TspClientResponse<String> tspClientResponse = RestClient.get(
                String.format(this.MARKER_SET_API_URL, this.getBaseUrl(), experimentUuid),
                Optional.empty(), String.class);

        return TspClientResponse.getGenericResponse(tspClientResponse,
                new TypeReference<GenericResponse<MarkerSet[]>>() {
                });
    }

}
