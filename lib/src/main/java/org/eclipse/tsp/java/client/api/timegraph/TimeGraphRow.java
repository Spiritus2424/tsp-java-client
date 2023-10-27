package org.eclipse.tsp.java.client.api.timegraph;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class TimeGraphRow {
	@NonNull
	private Long entryId;
	@NonNull
	private List<TimeGraphState> states;
}
