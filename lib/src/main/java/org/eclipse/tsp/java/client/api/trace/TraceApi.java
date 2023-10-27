package org.eclipse.tsp.java.client.api.trace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.api.trace.dto.OpenTraceRequestDto;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLogBuilder;

public class TraceApi extends AbstractTspApi {
	private final @NonNull Logger logger;
	private final String TRACE_API_URL;

	public TraceApi(String baseUrl) {
		super(baseUrl);
		this.logger = TraceCompassLog.getLogger(TraceApi.class);
		this.TRACE_API_URL = this.getBaseUrl().concat("/traces");
	}

	@Async
	public TspClientResponse<List<Trace>> getTraces(final Optional<Map<String, String>> queryParameters) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"TraceApi#getTraces").build()) {
			return this.getRestClientSingleton().get(this.TRACE_API_URL,
					queryParameters,
					this.getTypeFactory().constructCollectionType(List.class, Trace.class));
		}

	}

	@Async
	public TspClientResponse<Trace> getTrace(final UUID traceUuid) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"TraceApi#getTrace").build()) {
			return this.getRestClientSingleton().get(String.format(this.TRACE_API_URL.concat("/%s"), traceUuid),
					Optional.empty(),
					this.getTypeFactory().constructType(Trace.class));
		}
	}

	@Async
	public TspClientResponse<Trace> openTrace(final Body<OpenTraceRequestDto> body) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"TraceApi#openTrace").build()) {
			return this.getRestClientSingleton().post(this.TRACE_API_URL,
					Optional.of(body),
					Optional.empty(),
					this.getTypeFactory().constructType(Trace.class));
		}
	}

	@Async
	public TspClientResponse<List<Trace>> openTraces(final Body<OpenTraceRequestDto> body) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"TraceApi#openTraces").build()) {
			return this.getRestClientSingleton().post(this.TRACE_API_URL,
					Optional.of(body),
					Optional.empty(),
					this.getTypeFactory().constructCollectionType(List.class, Trace.class));
		}
	}

	@Async
	public TspClientResponse<Trace> deleteTrace(
			final UUID traceUuid,
			final Optional<Boolean> removeFromCache,
			final Optional<Boolean> deleteFromDisk) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"TraceApi#deleteTrace").build()) {
			Map<String, String> queryParameters = new HashMap<String, String>();
			if (removeFromCache.isPresent()) {
				queryParameters.put("removeCache", removeFromCache.get().toString());
			}

			if (deleteFromDisk.isPresent()) {
				queryParameters.put("deleteTrace", deleteFromDisk.get().toString());
			}

			return this.getRestClientSingleton().delete(String.format(this.TRACE_API_URL.concat("/%s"), traceUuid),
					Optional.of(queryParameters),
					this.getTypeFactory().constructType(Trace.class));
		}
	}

}
