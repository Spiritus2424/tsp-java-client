package org.eclipse.tsp.java.client.api.style;

import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLogBuilder;

public class StyleApi extends AbstractTspApi {
	private final @NonNull Logger logger;
	private final String STYLE_API_URL;

	public StyleApi(String baseUrl) {
		super(baseUrl);
		this.logger = TraceCompassLog.getLogger(StyleApi.class);
		this.STYLE_API_URL = this.getBaseUrl().concat("/experiments/%s/outputs/%s/style");
	}

	@Async
	public TspClientResponse<GenericResponse<OutputStyleModel>> getStyles(
			final UUID experimentUuid,
			final String outputId,
			final Query query) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"StyleApi#getStyles").setCategory(outputId).build()) {
			return this.getRestClientSingleton().post(String.format(this.STYLE_API_URL, experimentUuid, outputId),
					Optional.of(query),
					Optional.empty(),
					this.getTypeFactory().constructParametricType(GenericResponse.class, OutputStyleModel.class));
		}
	}
}
