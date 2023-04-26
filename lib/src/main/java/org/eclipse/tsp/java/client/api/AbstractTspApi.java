package org.eclipse.tsp.java.client.api;

import org.eclipse.tsp.java.client.core.restclient.RestClientSingleton;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import lombok.Getter;

public abstract class AbstractTspApi {

	@Getter
	private String baseUrl;

	@Getter
	private final RestClientSingleton restClientSingleton = RestClientSingleton.getInstance();

	public AbstractTspApi(String baseUrl) {
		this.baseUrl = String.format("%s/tsp/api", baseUrl);
	}

	public ObjectMapper getObjectMapper() {
		return this.restClientSingleton.getObjectMapper();
	}

	public TypeFactory getTypeFactory() {
		return this.getObjectMapper().getTypeFactory();
	}
}
