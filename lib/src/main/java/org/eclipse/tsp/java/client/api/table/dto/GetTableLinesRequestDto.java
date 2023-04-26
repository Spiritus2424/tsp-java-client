package org.eclipse.tsp.java.client.api.table.dto;

import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	private Integer requestedTableCount;

	@JsonProperty("requested_times")
	private List<BigInteger> requestedTimes;

	@JsonProperty("requested_table_index")
	private BigInteger requestedTableIndex;

	@JsonProperty("requested_table_column_ids")
	private List<BigInteger> requestedTableColumnIds;

	@JsonProperty("table_search_expressions")
	private Object tableSearchExpressions;

	@JsonProperty("table_search_direction")
	private TableSearchDirection tableSearchDirection;

	public enum TableSearchDirection {
		NEXT, PREVIOUS
	}
}
