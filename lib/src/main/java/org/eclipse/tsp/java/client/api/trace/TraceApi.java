package org.eclipse.tsp.java.client.api.trace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.api.trace.dto.OpenTraceRequestDto;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;

public class TraceApi extends AbstractTspApi {
	private final String TRACE_API_URL = "%s/traces";

	public TraceApi(String baseUrl) {
		super(baseUrl);
	}

	@Async
	public TspClientResponse<List<Trace>> getTraces(Optional<Map<String, String>> queryParameters) {
		return this.getRestClientSingleton().get(String.format(this.TRACE_API_URL, this.getBaseUrl()), queryParameters,
				this.getTypeFactory().constructCollectionType(List.class, Trace.class));
	}

	@Async
	public TspClientResponse<Trace> getTrace(UUID traceUuid) {
		return this.getRestClientSingleton().get(
				String.format(this.TRACE_API_URL.concat("/%s"), this.getBaseUrl(), traceUuid),
				Optional.empty(), this.getTypeFactory().constructType(Trace.class));
	}

	@Async
	public TspClientResponse<Trace> openTrace(OpenTraceRequestDto body) {
		return this.getRestClientSingleton().post(String.format(this.TRACE_API_URL, this.getBaseUrl()),
				Optional.of(body), this.getTypeFactory().constructType(Trace.class));
	}

	@Async
	public TspClientResponse<Trace> deleteTrace(UUID traceUuid, Optional<Boolean> removeFromCache,
			Optional<Boolean> deleteFromDisk) {
		Map<String, String> queryParameters = new HashMap<String, String>();
		if (removeFromCache.isPresent()) {
			queryParameters.put("removeCache", removeFromCache.get().toString());
		}

		if (deleteFromDisk.isPresent()) {
			queryParameters.put("deleteTrace", deleteFromDisk.get().toString());
		}

		return this.getRestClientSingleton().delete(
				String.format(this.TRACE_API_URL.concat("/%s"), this.getBaseUrl(), traceUuid),
				Optional.of(queryParameters), this.getTypeFactory().constructType(Trace.class));
	}

}
