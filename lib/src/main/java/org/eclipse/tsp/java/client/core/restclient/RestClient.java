package org.eclipse.tsp.java.client.core.restclient;

import java.util.Map;
import java.util.Optional;

import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class RestClient {

	private static ConnectionStatus connectionStatus = new ConnectionStatus();

	private static Client client = ClientBuilder.newClient();

	public static <T> TspClientResponse<T> get(String url, Optional<Map<String, String>> queryParameters,
			Class<? extends T> clazz) {
		WebTarget webTarget = client.target(url);
		if (queryParameters.isPresent()) {
			for (Map.Entry<String, String> queryParameter : queryParameters.get().entrySet()) {
				webTarget.queryParam(queryParameter.getKey(), queryParameter.getValue());
			}
		}

		Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
		checkResponseStatusCode(response.getStatusInfo().toEnum());

		return (response.hasEntity() && isResponseSuccess(response.getStatus()))
				? new TspClientResponse<T>(response.getStatusInfo().toEnum(),
						response.getStatusInfo().getReasonPhrase(), response.readEntity(clazz))
				: new TspClientResponse<T>(response.getStatusInfo().toEnum(),
						response.getStatusInfo().getReasonPhrase());
	}

	public static <T> TspClientResponse<T> post(String url, Optional<Object> body, Class<? extends T> clazz) {
		final Entity<Object> entity = body.isPresent() ? Entity.entity(body.get(), MediaType.APPLICATION_JSON) : null;

		Response response = client
				.target(url)
				.request(MediaType.APPLICATION_JSON)
				.post(entity);

		checkResponseStatusCode(response.getStatusInfo().toEnum());

		return (response.hasEntity() && isResponseSuccess(response.getStatus()))
				? new TspClientResponse<T>(response.getStatusInfo().toEnum(),
						response.getStatusInfo().getReasonPhrase(), response.readEntity(clazz))
				: new TspClientResponse<T>(response.getStatusInfo().toEnum(),
						response.getStatusInfo().getReasonPhrase());
	}

	public static <T> TspClientResponse<T> put(String url, Object body, Class<? extends T> clazz) {
		final Entity<Object> entity = Entity.entity(body, MediaType.APPLICATION_JSON);
		Response response = client
				.target(url)
				.request(MediaType.APPLICATION_JSON)
				.put(entity);
		checkResponseStatusCode(response.getStatusInfo().toEnum());

		return (response.hasEntity() && isResponseSuccess(response.getStatus()))
				? new TspClientResponse<T>(response.getStatusInfo().toEnum(),
						response.getStatusInfo().getReasonPhrase(), response.readEntity(clazz))
				: new TspClientResponse<T>(response.getStatusInfo().toEnum(),
						response.getStatusInfo().getReasonPhrase());
	}

	public static <T> TspClientResponse<T> delete(String url, Optional<Map<String, String>> queryParameters,
			Class<? extends T> clazz) {
		WebTarget webTarget = client.target(url);
		if (queryParameters.isPresent()) {
			for (Map.Entry<String, String> queryParameter : queryParameters.get().entrySet()) {
				webTarget.queryParam(queryParameter.getKey(), queryParameter.getValue());
			}
		}

		Response response = webTarget.request(MediaType.APPLICATION_JSON).delete();
		checkResponseStatusCode(response.getStatusInfo().toEnum());

		return (response.hasEntity() && isResponseSuccess(response.getStatus()))
				? new TspClientResponse<T>(response.getStatusInfo().toEnum(),
						response.getStatusInfo().getReasonPhrase(), response.readEntity(clazz))
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

	private static boolean isResponseSuccess(int status) {
		return status >= 200 && status < 300;
	}

	private static void updateConnectionStatus(boolean status) {
		if (connectionStatus.isStatus() != status) {
			connectionStatus.setStatus(status);
		}
	}

}
