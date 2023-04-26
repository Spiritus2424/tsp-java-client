package org.eclipse.tsp.java.client.api.trace.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class OpenTraceRequestDto {

	@NonNull
	private String uri;

	private String name;

	private String typeId;

}
