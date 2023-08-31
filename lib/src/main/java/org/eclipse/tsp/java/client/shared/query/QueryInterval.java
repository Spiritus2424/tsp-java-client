package org.eclipse.tsp.java.client.shared.query;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
	@NotNull
	private Long start;

	@NonNull
	@NotNull
	private Long end;

	@Min(0)
	@Max(Integer.MAX_VALUE)
	private Integer nbTimes;

}
