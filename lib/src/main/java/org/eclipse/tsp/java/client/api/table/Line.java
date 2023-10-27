package org.eclipse.tsp.java.client.api.table;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Line {
	@NonNull
	private Long index;
	@NonNull
	private List<Cell> cells;
	private Integer tags;

}
