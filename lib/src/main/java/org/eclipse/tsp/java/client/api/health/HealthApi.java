package org.eclipse.tsp.java.client.api.health;

import java.util.Optional;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;

public class HealthApi extends AbstractTspApi {
	private final String HEALTH_API_URL;

	public HealthApi(String baseUrl) {
		super(baseUrl);
		this.HEALTH_API_URL = this.getBaseUrl().concat("/health");
	}

	@Async
	public TspClientResponse<Health> checkHealth() {
		return this.getRestClientSingleton().get(this.HEALTH_API_URL,
				Optional.empty(),
				this.getTypeFactory().constructType(Health.class));
	}
}
