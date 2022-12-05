package org.eclipse.tsp.java.client.models.style;

import java.util.HashMap;
import java.util.Map;

public class OutputStyleModel {
    private Map<String, OutputElementStyle> styles;

    public OutputStyleModel() {
        this.styles = new HashMap<>();
    }

    public OutputStyleModel(Map<String, OutputElementStyle> styles) {
        this.styles = styles;
    }

    public Map<String, OutputElementStyle> getStyles() {
        return styles;
    }

    public void setStyles(Map<String, OutputElementStyle> styles) {
        this.styles = styles;
    }
}
