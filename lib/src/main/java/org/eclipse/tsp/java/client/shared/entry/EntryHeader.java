package org.eclipse.tsp.java.client.shared.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class EntryHeader {
	@NonNull
	private String name;
	@NonNull
	private String tooltip;

	private DataType dataType;

}
