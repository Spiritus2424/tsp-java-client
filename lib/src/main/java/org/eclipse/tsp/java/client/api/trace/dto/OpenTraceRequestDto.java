package org.eclipse.tsp.java.client.api.trace.dto;

import jakarta.ws.rs.DefaultValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class OpenTraceRequestDto {
	@NonNull
	private String uri;

	private String name;

	private String typeId;

	@DefaultValue("false")
	private boolean isRecursively;
}
