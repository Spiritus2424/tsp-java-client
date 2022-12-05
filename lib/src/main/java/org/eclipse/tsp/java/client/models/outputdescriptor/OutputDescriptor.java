package org.eclipse.tsp.java.client.models.outputdescriptor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OutputDescriptor {
    private String id;
    private String name;
    private String description;
    private String type;
    private Map<String, Object> queryParameters;
    private BigInteger start;
    private BigInteger end;
    private boolean isFinal;
    private ArrayList<String> compatibleProviders;

    public OutputDescriptor() {
        this.queryParameters = new HashMap<>();
        this.compatibleProviders = new ArrayList<>();
    }

    public OutputDescriptor(String id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public OutputDescriptor(String id, String name, String description, String type,
            Map<String, Object> queryParameters) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.queryParameters = queryParameters;
    }

    public OutputDescriptor(String id, String name, String description, String type,
            Map<String, Object> queryParameters, BigInteger start) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.queryParameters = queryParameters;
        this.start = start;
    }

    public OutputDescriptor(String id, String name, String description, String type,
            Map<String, Object> queryParameters, BigInteger start, BigInteger end) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.queryParameters = queryParameters;
        this.start = start;
        this.end = end;
    }

    public OutputDescriptor(String id, String name, String description, String type,
            Map<String, Object> queryParameters, BigInteger start, BigInteger end, boolean isFinal) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.queryParameters = queryParameters;
        this.start = start;
        this.end = end;
        this.isFinal = isFinal;
    }

    public OutputDescriptor(String id, String name, String description, String type,
            Map<String, Object> queryParameters, BigInteger start, BigInteger end, boolean isFinal,
            ArrayList<String> compatibleProviders) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.queryParameters = queryParameters;
        this.start = start;
        this.end = end;
        this.isFinal = isFinal;
        this.compatibleProviders = compatibleProviders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getQueryParameters() {
        return queryParameters;
    }

    public void setQueryParameters(Map<String, Object> queryParameters) {
        this.queryParameters = queryParameters;
    }

    public BigInteger getStart() {
        return start;
    }

    public void setStart(BigInteger start) {
        this.start = start;
    }

    public BigInteger getEnd() {
        return end;
    }

    public void setEnd(BigInteger end) {
        this.end = end;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public ArrayList<String> getCompatibleProviders() {
        return compatibleProviders;
    }

    public void setCompatibleProviders(ArrayList<String> compatibleProviders) {
        this.compatibleProviders = compatibleProviders;
    }
}
