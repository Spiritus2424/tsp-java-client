package org.eclipse.tsp.java.client.api.markerset;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLogBuilder;

public class MarkerSetApi extends AbstractTspApi {
	private final @NonNull Logger logger;
	private final String MARKER_SET_API_URL;

	public MarkerSetApi(String baseUrl) {
		super(baseUrl);
		this.logger = TraceCompassLog.getLogger(MarkerSetApi.class);
		this.MARKER_SET_API_URL = this.getBaseUrl().concat("/experiments/%s/outputs/markerSets");
	}

	@Async
	public TspClientResponse<GenericResponse<Set<MarkerSet>>> getMarkerSets(final UUID experimentUuid) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"MarkerSetApi#getMarkerSets").build()) {
			return this.getRestClientSingleton().get(String.format(this.MARKER_SET_API_URL, experimentUuid),
					Optional.empty(),
					this.getTypeFactory().constructParametricType(GenericResponse.class,
							this.getTypeFactory().constructCollectionType(Set.class, MarkerSet.class)));
		}
	}

}
