package org.eclipse.tsp.java.client.models.query;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Query {
    @NonNull
    private final Map<String, Object> parameters;

    public Query() {
        this.parameters = new HashMap<String, Object>();
    }

}
