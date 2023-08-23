package org.eclipse.tsp.java.client.api.timegraph;

import org.eclipse.tsp.java.client.api.style.OutputElementStyle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class TimeGraphState {
	@NonNull
	private Long start;
	@NonNull
	private Long end;
	private String label;
	private Integer tags;
	private OutputElementStyle style;
}
