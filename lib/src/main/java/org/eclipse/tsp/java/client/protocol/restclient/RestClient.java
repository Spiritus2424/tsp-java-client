package org.eclipse.tsp.java.client.protocol.restclient;

import java.util.Map;
import java.util.Optional;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class RestClient {
    private static boolean status = false;

    @SuppressWarnings("unchecked")
    public static <T> TspClientResponse<T> get(String uri, Optional<Map<String, String>> queryParameters)
            throws ClassCastException {
        WebTarget webTarget = ClientBuilder.newClient().target(uri);
        if (queryParameters.isPresent()) {
            for (Map.Entry<String, String> queryParameter : queryParameters.get().entrySet()) {
                webTarget.queryParam(queryParameter.getKey(), queryParameter.getValue());
            }
        }

        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
        return (response.hasEntity())
                ? new TspClientResponse<T>("response", response.getStatusInfo().toEnum(),
                        response.getStatusInfo().getReasonPhrase(), (T) response.getEntity())
                : new TspClientResponse<T>("response", response.getStatusInfo().toEnum(),
                        response.getStatusInfo().getReasonPhrase());
    }
}
