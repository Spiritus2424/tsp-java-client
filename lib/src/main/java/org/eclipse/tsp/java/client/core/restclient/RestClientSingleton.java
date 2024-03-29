package org.eclipse.tsp.java.client.core.restclient;

import java.util.Map;
import java.util.Optional;

import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.Getter;

public class RestClientSingleton {
	private static final RestClientSingleton instance = new RestClientSingleton();

	public static RestClientSingleton getInstance() {
		return instance;
	}

	@Getter
	private final ObjectMapper objectMapper;
	private final Client client;
	private final ConnectionStatus connectionStatus;

	private RestClientSingleton() {
		// Private constructor to prevent instantiation from outside
		this.objectMapper = new ObjectMapper();
		this.client = ClientBuilder.newClient();
		this.connectionStatus = new ConnectionStatus();

	}

	public <T> TspClientResponse<T> get(String url, Optional<Map<String, String>> queryParameters, JavaType javaType) {
		WebTarget webTarget = client.target(url);
		if (queryParameters.isPresent()) {
			for (Map.Entry<String, String> queryParameter : queryParameters.get().entrySet()) {
				webTarget.queryParam(queryParameter.getKey(), queryParameter.getValue());
			}
		}

		Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
		checkResponseStatusCode(response.getStatusInfo().toEnum());

		return createTspClientResponse(response, javaType);
	}

	public <T> TspClientResponse<T> post(String url, Optional<Object> body, JavaType javaType) {
		Entity<Object> entity = null;
		if (body.isPresent()) {
			String jsonBody = null;
			try {
				jsonBody = objectMapper.writeValueAsString(body.get());
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			entity = Entity.json(jsonBody);
		}

		Response response = client.target(url)
				.request(MediaType.APPLICATION_JSON)
				.post(entity);

		checkResponseStatusCode(response.getStatusInfo().toEnum());
		return createTspClientResponse(response, javaType);
	}

	public <T> TspClientResponse<T> put(String url, Object body, JavaType javaType) {
		String jsonBody = null;
		try {
			jsonBody = objectMapper.writeValueAsString(body);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		final Entity<Object> entity = Entity.json(jsonBody);
		Response response = client
				.target(url)
				.request(MediaType.APPLICATION_JSON)
				.put(entity);
		checkResponseStatusCode(response.getStatusInfo().toEnum());

		return createTspClientResponse(response, javaType);
	}

	public <T> TspClientResponse<T> delete(String url, Optional<Map<String, String>> queryParameters,
			JavaType javaType) {
		WebTarget webTarget = client.target(url);
		if (queryParameters.isPresent()) {
			for (Map.Entry<String, String> queryParameter : queryParameters.get().entrySet()) {
				webTarget.queryParam(queryParameter.getKey(), queryParameter.getValue());
			}
		}

		Response response = webTarget.request(MediaType.APPLICATION_JSON).delete();
		checkResponseStatusCode(response.getStatusInfo().toEnum());

		return createTspClientResponse(response, javaType);
	}

	public void addConnectionStatusListener(PclConnectionStatus pclConnectionStatus) {
		connectionStatus.addPropertyChangeListener(pclConnectionStatus);
	}

	public void removeConnectionStatusListener(PclConnectionStatus pclConnectionStatus) {
		connectionStatus.removePropertyChangeListener(pclConnectionStatus);
	}

	private synchronized <T> TspClientResponse<T> createTspClientResponse(Response response, JavaType javaType) {
		TspClientResponse<T> tspClientResponse = null;

		if (response.hasEntity() && isResponseSuccess(response.getStatus())) {
			String jsonEntity = response.readEntity(String.class);
			T entity = null;
			try {
				entity = objectMapper.readValue(jsonEntity, javaType);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			tspClientResponse = new TspClientResponse<T>(response.getStatusInfo().toEnum(),
					response.getStatusInfo().getReasonPhrase(), entity);
		} else if (response.hasEntity()) {
			tspClientResponse = new TspClientResponse<T>(response.getStatusInfo().toEnum(),
					response.getStatusInfo().getReasonPhrase().concat(": ").concat(response.readEntity(String.class)));
		} else {
			tspClientResponse = new TspClientResponse<T>(response.getStatusInfo().toEnum(),
					response.getStatusInfo().getReasonPhrase());

		}
		return tspClientResponse;
	}

	private void checkResponseStatusCode(Status status) {
		updateConnectionStatus(status.getStatusCode() <= 500);
	}

	private boolean isResponseSuccess(int status) {
		return status >= 200 && status < 300;
	}

	private void updateConnectionStatus(boolean status) {
		if (connectionStatus.isStatus() != status) {
			connectionStatus.setStatus(status);
		}
	}

}
