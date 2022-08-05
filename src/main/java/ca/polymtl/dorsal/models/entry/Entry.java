package ca.polymtl.dorsal.models.entry;

import java.util.ArrayList;
import java.util.Map;

import ca.polymtl.dorsal.models.style.OutputElementStyle;

public class Entry {
    private int id;
    private ArrayList<String> labels;
    private int parentId;
    private Boolean hasData;
    private OutputElementStyle style;
    private Map<String, Object> metadata;
}
