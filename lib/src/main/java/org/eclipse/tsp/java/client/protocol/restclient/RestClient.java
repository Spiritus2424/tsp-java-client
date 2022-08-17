package org.eclipse.tsp.java.client.protocol.restclient;

import java.util.Map;
import java.util.Optional;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class RestClient {
    private static ConnectionStatus connectionStatus;

    @SuppressWarnings("unchecked")
    public static <T> TspClientResponse<T> get(String url, Optional<Map<String, String>> queryParameters)
            throws ClassCastException {
        WebTarget webTarget = ClientBuilder.newClient().target(url);
        if (queryParameters.isPresent()) {
            for (Map.Entry<String, String> queryParameter : queryParameters.get().entrySet()) {
                webTarget.queryParam(queryParameter.getKey(), queryParameter.getValue());
            }
        }

        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
        checkResponseStatusCode(response.getStatusInfo().toEnum());
        return (response.hasEntity())
                ? new TspClientResponse<T>(response.getStatusInfo().toEnum(),
                        response.getStatusInfo().getReasonPhrase(), (T) response.getEntity())
                : new TspClientResponse<T>(response.getStatusInfo().toEnum(),
                        response.getStatusInfo().getReasonPhrase());
    }

    public static <T> TspClientResponse<T> post(String url, Optional<Entity<Object>> body) {
        Response response = ClientBuilder.newClient().target(url).request(MediaType.APPLICATION_JSON).post(body.get());
        checkResponseStatusCode(response.getStatusInfo().toEnum());
        return new TspClientResponse<T>(response.getStatusInfo().toEnum(),
                response.getStatusInfo().getReasonPhrase());
    }

    public static <T> TspClientResponse<T> put(String url, Optional<Entity<Object>> body) {
        Response response = ClientBuilder.newClient().target(url).request(MediaType.APPLICATION_JSON).put(body.get());
        checkResponseStatusCode(response.getStatusInfo().toEnum());
        return new TspClientResponse<T>(response.getStatusInfo().toEnum(),
                response.getStatusInfo().getReasonPhrase());
    }

    @SuppressWarnings("unchecked")
    public static <T> TspClientResponse<T> delete(String url, Optional<Map<String, String>> queryParameters)
            throws ClassCastException {
        WebTarget webTarget = ClientBuilder.newClient().target(url);
        if (queryParameters.isPresent()) {
            for (Map.Entry<String, String> queryParameter : queryParameters.get().entrySet()) {
                webTarget.queryParam(queryParameter.getKey(), queryParameter.getValue());
            }
        }

        Response response = webTarget.request(MediaType.APPLICATION_JSON).delete();
        checkResponseStatusCode(response.getStatusInfo().toEnum());

        return (response.hasEntity())
                ? new TspClientResponse<T>(response.getStatusInfo().toEnum(),
                        response.getStatusInfo().getReasonPhrase(), (T) response.getEntity())
                : new TspClientResponse<T>(response.getStatusInfo().toEnum(),
                        response.getStatusInfo().getReasonPhrase());
    }

    public static void addConnectionStatusListener(PclConnectionStatus pclConnectionStatus) {
        connectionStatus.addPropertyChangeListener(pclConnectionStatus);
    }

    public static void removeConnectionStatusListener(PclConnectionStatus pclConnectionStatus) {
        connectionStatus.removePropertyChangeListener(pclConnectionStatus);
    }

    private static void checkResponseStatusCode(Status status) {
        updateConnectionStatus(status.getStatusCode() <= 500);
    }

    private static void updateConnectionStatus(boolean status) {
        if (connectionStatus.isStatus() != status) {
            connectionStatus.setStatus(status);
        }
    }

}
