package org.eclipse.tsp.java.client.models.response;

import org.eclipse.tsp.java.client.models.annotation.AnnotationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class GenericResponse<T> {

    private T model;
    private ResponseStatus status;
    private String message;

    public GenericResponse() {
    }

    public GenericResponse(T model, ResponseStatus status, String message) {
        this.model = model;
        this.status = status;
        this.message = message;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
    @JsonSubTypes({
            @JsonSubTypes.Type(AnnotationModel.class),
    // @JsonSubTypes.Type(AnnotationCategoriesModel.class),
    })
    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    @JsonProperty("statusMessage")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void normalize() {
        throw new UnsupportedOperationException();
    }

}
