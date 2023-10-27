package org.eclipse.tsp.java.client.api.health;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLogBuilder;

public class HealthApi extends AbstractTspApi {
	private final @NonNull Logger logger;
	private final String HEALTH_API_URL;

	public HealthApi(String baseUrl) {
		super(baseUrl);
		this.logger = TraceCompassLog.getLogger(HealthApi.class);
		this.HEALTH_API_URL = this.getBaseUrl().concat("/health");
	}

	@Async
	public TspClientResponse<Health> checkHealth() {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"HealthApi#checkHealth").build()) {
			return this.getRestClientSingleton().get(this.HEALTH_API_URL,
					Optional.empty(),
					this.getTypeFactory().constructType(Health.class));

		}
	}
}
