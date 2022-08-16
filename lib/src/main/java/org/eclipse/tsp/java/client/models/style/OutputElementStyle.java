package org.eclipse.tsp.java.client.models.style;

import java.util.Map;

public class OutputElementStyle {
    private String parentKey;
    private Map<String, Object> values;

    public OutputElementStyle(String parentKey, Map<String, Object> values) {
        this.parentKey = parentKey;
        this.values = values;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }
}
