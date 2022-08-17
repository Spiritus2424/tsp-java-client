package org.eclipse.tsp.java.client.protocol.restclient;

import jakarta.ws.rs.core.Response.Status;

public class TspClientResponse<T> {
    private Status statusCode;
    private String statusMessage;
    private T responseModel;

    public TspClientResponse(Status statusCode, String statusMessage, T responseModel) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.responseModel = responseModel;
    }

    public TspClientResponse(Status statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
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
