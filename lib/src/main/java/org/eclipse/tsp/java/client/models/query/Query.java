package org.eclipse.tsp.java.client.models.query;

import java.util.HashMap;
import java.util.Map;

public class Query {
    private Map<String, Object> parameters;

    public Query() {
        this.parameters = new HashMap<>();
    }

    public Query(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public final Map<String, Object> getParameters() {
        return Map.copyOf(parameters);
    }

}
