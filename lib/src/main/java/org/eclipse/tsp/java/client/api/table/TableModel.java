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
	private Long lowIndex;
	@NonNull
	private Long size;
	@NonNull
	private List<Long> columnIds;
	@NonNull
	private List<Line> lines;

}
