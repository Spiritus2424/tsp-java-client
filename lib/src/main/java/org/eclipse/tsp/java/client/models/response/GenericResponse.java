package org.eclipse.tsp.java.client.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {
    private T model;
    @NonNull
    private ResponseStatus status;
    @JsonProperty("statusMessage")
    @NonNull
    private String message;
}
