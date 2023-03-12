package org.eclipse.tsp.java.client.timegraph;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.tsp.java.client.shared.entry.EntryModel;
import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.restclient.RestClient;
import org.eclipse.tsp.java.client.shared.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.tsp.AbstractTspApi;

import com.fasterxml.jackson.core.type.TypeReference;

public class TimeGraphApi extends AbstractTspApi {
        private final String TIME_GRAPH_API_URL = "%s/experiments/%s/outputs/timeGraph/%s";

        public TimeGraphApi(String baseUrl) {
                super(baseUrl);
        }

        public TspClientResponse<GenericResponse<EntryModel<TimeGraphEntry>>> getTimeGraphTree(UUID experimentUuid,
                        String outputId, Query query) {
                final TspClientResponse<String> tspClientResponse = RestClient.post(
                                String.format(this.TIME_GRAPH_API_URL.concat("/tree"), this.getBaseUrl(),
                                                experimentUuid, outputId),
                                Optional.of(query), String.class);

                return TspClientResponse.getGenericResponse(tspClientResponse,
                                new TypeReference<GenericResponse<EntryModel<TimeGraphEntry>>>() {
                                });
        }

        public TspClientResponse<GenericResponse<TimeGraphModel>> getTimeGraphStates(UUID experimentUuid,
                        String outputId,
                        Query query) {
                final TspClientResponse<String> tspClientResponse = RestClient.post(
                                String.format(this.TIME_GRAPH_API_URL.concat("/states"), this.getBaseUrl(),
                                                experimentUuid, outputId),
                                Optional.of(query), String.class);

                return TspClientResponse.getGenericResponse(tspClientResponse,
                                new TypeReference<GenericResponse<TimeGraphModel>>() {
                                });
        }

        public TspClientResponse<GenericResponse<TimeGraphArrow[]>> getTimeGraphArrows(UUID experimentUuid,
                        String outputId, Query query) {
                final TspClientResponse<String> tspClientResponse = RestClient.post(
                                String.format(this.TIME_GRAPH_API_URL.concat("/arrows"), this.getBaseUrl(),
                                                experimentUuid, outputId),
                                Optional.of(query), String.class);

                return TspClientResponse.getGenericResponse(tspClientResponse,
                                new TypeReference<GenericResponse<TimeGraphArrow[]>>() {
                                });
        }

        public TspClientResponse<GenericResponse<Map<String, String>>> getTimeGraphTooltip(UUID experimentUuid,
                        String outputId,
                        Query query) {
                TspClientResponse<String> tspClientResponse = RestClient.post(
                                String.format(this.TIME_GRAPH_API_URL.concat("/tooltip"), this.getBaseUrl(),
                                                experimentUuid, outputId),
                                Optional.of(query), String.class);
                return TspClientResponse.getGenericResponse(tspClientResponse,
                                new TypeReference<GenericResponse<Map<String, String>>>() {
                                });
        }

}
