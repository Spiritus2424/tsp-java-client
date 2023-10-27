package org.eclipse.tsp.java.client.api.outputdescriptor;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLogBuilder;

public class OutputDescriptorApi extends AbstractTspApi {
	private final @NonNull Logger logger;
	private final String OUTPUT_DESCRIPTOR_API_URL;

	public OutputDescriptorApi(String baseUrl) {
		super(baseUrl);
		this.logger = TraceCompassLog.getLogger(OutputDescriptorApi.class);
		this.OUTPUT_DESCRIPTOR_API_URL = this.getBaseUrl().concat("/experiments/%s/outputs");
	}

	@Async
	public TspClientResponse<List<OutputDescriptor>> experimentOutputs(
			final UUID experimentUuid,
			final Optional<Map<String, String>> queryParameters) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"OutputDescriptorApi#experimentOutputs").build()) {
			return this.getRestClientSingleton().get(String.format(this.OUTPUT_DESCRIPTOR_API_URL, experimentUuid),
					queryParameters,
					this.getTypeFactory().constructCollectionType(List.class, OutputDescriptor.class));
		}
	}

}
