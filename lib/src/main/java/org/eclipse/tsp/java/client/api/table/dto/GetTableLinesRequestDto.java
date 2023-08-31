package org.eclipse.tsp.java.client.api.table.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class GetTableLinesRequestDto {
	@JsonProperty("requested_table_count")
	@NonNull
	@NotNull
	private Integer requestedTableCount;

	@JsonProperty("requested_times")
	private List<Long> requestedTimes;

	@JsonProperty("requested_table_index")
	private Long requestedTableIndex;

	@JsonProperty("requested_table_column_ids")
	private List<Long> requestedTableColumnIds;

	@JsonProperty("table_search_expressions")
	private Object tableSearchExpressions;

	@JsonProperty("table_search_direction")
	private TableSearchDirection tableSearchDirection;

	public enum TableSearchDirection {
		NEXT, PREVIOUS
	}
}
