package org.eclipse.tsp.java.client.shared.query;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class TimeRange {
	@NonNull
	private Long start;
	@NonNull
	private Long end;
}
