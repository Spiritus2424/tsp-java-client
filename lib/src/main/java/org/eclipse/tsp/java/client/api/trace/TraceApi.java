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
import org.eclipse.tsp.java.client.shared.query.Body;

public class TraceApi extends AbstractTspApi {
	private final String TRACE_API_URL;

	public TraceApi(String baseUrl) {
		super(baseUrl);
		this.TRACE_API_URL = this.getBaseUrl().concat("/traces");
	}

	@Async
	public TspClientResponse<List<Trace>> getTraces(final Optional<Map<String, String>> queryParameters) {
		return this.getRestClientSingleton().get(this.TRACE_API_URL,
				queryParameters,
				this.getTypeFactory().constructCollectionType(List.class, Trace.class));
	}

	@Async
	public TspClientResponse<Trace> getTrace(final UUID traceUuid) {
		return this.getRestClientSingleton().get(String.format(this.TRACE_API_URL.concat("/%s"), traceUuid),
				Optional.empty(),
				this.getTypeFactory().constructType(Trace.class));
	}

	@Async
	public TspClientResponse<Trace> openTrace(final Body<OpenTraceRequestDto> body) {
		return this.getRestClientSingleton().post(this.TRACE_API_URL,
				Optional.of(body),
				this.getTypeFactory().constructType(Trace.class));
	}

	@Async
	public TspClientResponse<Trace> deleteTrace(
			final UUID traceUuid,
			final Optional<Boolean> removeFromCache,
			final Optional<Boolean> deleteFromDisk) {
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
