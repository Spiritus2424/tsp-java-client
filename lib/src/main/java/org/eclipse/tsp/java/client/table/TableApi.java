package org.eclipse.tsp.java.client.table;

import java.util.Optional;
import java.util.UUID;

import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.restclient.RestClient;
import org.eclipse.tsp.java.client.shared.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.tspapi.AbstractTspApi;

import com.fasterxml.jackson.core.type.TypeReference;

public class TableApi extends AbstractTspApi {
        private final String TABLE_API_URL = "%s/experiments/%s/outputs/table/%s";

        public TableApi(String baseUrl) {
                super(baseUrl);
        }

        public TspClientResponse<GenericResponse<ColumnHeaderEntry[]>> getTableColumns(UUID experimentUuid,
                        String outputId,
                        Query query) {
                TspClientResponse<String> tspClientResponse = RestClient.post(
                                String.format(this.TABLE_API_URL.concat("/columns"), this.getBaseUrl(), experimentUuid,
                                                outputId),
                                Optional.of(query), String.class);

                return TspClientResponse.getGenericResponse(tspClientResponse,
                                new TypeReference<GenericResponse<ColumnHeaderEntry[]>>() {
                                });
        }

        public TspClientResponse<GenericResponse<TableModel>> getTableLines(UUID experimentUuid, String outputId,
                        Query query) {
                TspClientResponse<String> tspClientResponse = RestClient.post(
                                String.format(this.TABLE_API_URL.concat("/lines"), this.getBaseUrl(), experimentUuid,
                                                outputId),
                                Optional.of(query), String.class);

                return TspClientResponse.getGenericResponse(tspClientResponse,
                                new TypeReference<GenericResponse<TableModel>>() {
                                });
        }
}
