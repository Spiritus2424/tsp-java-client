package org.eclipse.tsp.java.client.core.tspclient;

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
}
