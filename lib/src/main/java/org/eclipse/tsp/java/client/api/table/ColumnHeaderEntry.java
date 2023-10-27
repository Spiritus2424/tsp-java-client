package org.eclipse.tsp.java.client.api.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class ColumnHeaderEntry {
	@NonNull
	private Long id;
	@NonNull
	private String name;

	private String description;

	private String type;
}
