package org.eclipse.tsp.java.client.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {
    @NonNull
    private T model;
    @NonNull
    private ResponseStatus status;
    @JsonProperty("statusMessage")
    @NonNull
    private String message;
}
