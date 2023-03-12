package org.eclipse.tsp.java.client.shared.tspclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.core.Response.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TspClientResponse<T> {
    @NonNull
    private Status statusCode;
    @NonNull
    private String statusMessage;
    private T responseModel;

    public boolean isOk() {
        return this.statusCode == Status.OK;
    }

    public static <T> TspClientResponse<T> getGenericResponse(TspClientResponse<String> tspClientResponse,
            TypeReference<T> typeReferene) {
        T genericResponse = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            genericResponse = objectMapper.readValue(tspClientResponse.getResponseModel(), typeReferene);
        } catch (JsonMappingException exception) {
            System.err.println(exception);
        } catch (JsonProcessingException exception) {
            System.err.println(exception);
        }

        return new TspClientResponse<T>(tspClientResponse.getStatusCode(),
                tspClientResponse.getStatusMessage(), genericResponse);
    }
}
