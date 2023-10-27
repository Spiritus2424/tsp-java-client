package org.eclipse.tsp.java.client.api.graph;

import java.util.List;

import org.eclipse.tsp.java.client.api.timegraph.TimeGraphArrow;
import org.eclipse.tsp.java.client.api.timegraph.TimeGraphRow;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class GraphDto {
	@NonNull
	private List<TimeGraphRow> rows;

	@NonNull
	private List<TimeGraphArrow> arrows;
}
