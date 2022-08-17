package org.eclipse.tsp.java.client.protocol.restclient;

import jakarta.ws.rs.core.Response.Status;

public class TspClientResponse<T> {
    private String text;
    private Status statusCode;
    private String statusMessage;
    private T responseModel;

    public TspClientResponse(String text, Status statusCode, String statusMessage, T responseModel) {
        this.text = text;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.responseModel = responseModel;
    }

    public TspClientResponse(String text, Status statusCode, String statusMessage) {
        this.text = text;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String getText() {
        return text;
    }

    public Status getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public T getResponseModel() {
        return responseModel;
    }

    public boolean isOk() {
        return this.statusCode == Status.OK;
    }
}
