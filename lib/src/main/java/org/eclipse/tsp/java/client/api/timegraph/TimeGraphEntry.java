package org.eclipse.tsp.java.client.api.timegraph;

import org.eclipse.tsp.java.client.shared.entry.Entry;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@NoArgsConstructor
public class TimeGraphEntry extends Entry {
	@NonNull
	private Long start;
	@NonNull
	private Long end;

}
