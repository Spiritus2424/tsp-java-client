package org.eclipse.tsp.java.client.api.graph;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TcpEventKey {

	@NonNull
	private Long seq;
	@NonNull
	private Long ackseq;
	@NonNull
	private Long flags;
}
