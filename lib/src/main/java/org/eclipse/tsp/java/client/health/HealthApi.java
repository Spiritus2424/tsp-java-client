package org.eclipse.tsp.java.client.health;

import java.util.Optional;

import org.eclipse.tsp.java.client.shared.restclient.RestClient;
import org.eclipse.tsp.java.client.shared.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.tspapi.AbstractTspApi;

public class HealthApi extends AbstractTspApi {
    private final String HEALTH_API_URL = "%s/health";

    public HealthApi(String baseUrl) {
        super(baseUrl);
    }

    public TspClientResponse<Health> checkHealth() {
        return RestClient.get(String.format(this.HEALTH_API_URL, this.getBaseUrl()), Optional.empty(), Health.class);
    }
}
