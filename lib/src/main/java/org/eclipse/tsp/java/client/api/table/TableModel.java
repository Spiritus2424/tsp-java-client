package org.eclipse.tsp.java.client.api.table;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class TableModel {
	@NonNull
	private Integer lowIndex;
	@NonNull
	private Integer size;
	@NonNull
	private List<Integer> columnIds;
	@NonNull
	private List<Line> lines;

}
