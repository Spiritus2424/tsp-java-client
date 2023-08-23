package org.eclipse.tsp.java.client.shared.entry;

import java.util.List;
import java.util.Map;

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
public class Entry {
	@NonNull
	private Long id;
	@NonNull
	private List<String> labels;

	private Long parentId;
	private Boolean hasData;
	private OutputElementStyle style;
	private Map<String, Object> metadata;
	private Boolean isDefault = false;

}
