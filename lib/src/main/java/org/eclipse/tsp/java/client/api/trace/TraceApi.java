package org.eclipse.tsp.java.client.api.trace;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.restclient.RestClient;
import org.eclipse.tsp.java.client.shared.tspclient.TspClientResponse;

public class TraceApi extends AbstractTspApi {
    private final String TRACE_API_URL = "%s/traces";

    public TraceApi(String baseUrl) {
        super(baseUrl);
    }

    public TspClientResponse<Trace[]> getTraces(Optional<Map<String, String>> queryParameters) {
        return RestClient.get(String.format(this.TRACE_API_URL, this.getBaseUrl()), queryParameters, Trace[].class);
    }

    public TspClientResponse<Trace> getTrace(UUID traceUuid) {
        return RestClient.get(String.format(this.TRACE_API_URL.concat("%s"), this.getBaseUrl(), traceUuid),
                Optional.empty(), Trace.class);
    }

    public TspClientResponse<Trace> openTrace(Query query) {
        return RestClient.post(String.format(this.TRACE_API_URL, this.getBaseUrl()), Optional.of(query), Trace.class);
    }

    public TspClientResponse<Trace> deleteTrace(UUID traceUuid, Optional<Boolean> removeFromCache,
            Optional<Boolean> deleteFromDisk) {
        Map<String, String> queryParameters = new HashMap<String, String>();
        if (removeFromCache.isPresent()) {
            queryParameters.put("removeCache", removeFromCache.get().toString());
        }

        if (deleteFromDisk.isPresent()) {
            queryParameters.put("deleteTrace", deleteFromDisk.get().toString());
        }

        return RestClient.delete(String.format(this.TRACE_API_URL.concat("%s"), this.getBaseUrl(), traceUuid),
                Optional.of(queryParameters),
                Trace.class);
    }

}
