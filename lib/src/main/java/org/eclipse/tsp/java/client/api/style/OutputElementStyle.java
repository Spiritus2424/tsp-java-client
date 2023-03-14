package org.eclipse.tsp.java.client.api.style;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputElementStyle {
    private String parentKey;
    private Map<String, Object> values;
}
