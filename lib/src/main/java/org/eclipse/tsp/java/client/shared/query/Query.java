package org.eclipse.tsp.java.client.shared.query;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Query {
    @NonNull
    private final Map<String, Object> parameters;

    public Query() {
        this.parameters = new HashMap<String, Object>();
    }

}
