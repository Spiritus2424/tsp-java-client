package org.eclipse.tsp.java.client.api.health;

import java.util.Optional;

import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.core.restclient.RestClient;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;

public class HealthApi extends AbstractTspApi {
    private final String HEALTH_API_URL = "%s/health";

    public HealthApi(String baseUrl) {
        super(baseUrl);
    }

    public TspClientResponse<Health> checkHealth() {
        return RestClient.get(String.format(this.HEALTH_API_URL, this.getBaseUrl()), Optional.empty(), Health.class);
    }
}
