package org.eclipse.tsp.java.client.shared.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class QueryInterval {
	@NonNull
	private Long start;
	@NonNull
	private Long end;
	private Integer nbTimes;

}
