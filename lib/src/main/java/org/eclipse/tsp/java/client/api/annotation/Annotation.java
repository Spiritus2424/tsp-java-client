package org.eclipse.tsp.java.client.api.annotation;

import org.eclipse.tsp.java.client.api.style.OutputElementStyle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Annotation
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Annotation {
	@NonNull
	private String label;
	@NonNull
	private Long time;
	@NonNull
	private Long duration;
	@NonNull
	private Long entryId;
	@NonNull
	private AnnotationType type;

	private OutputElementStyle style;
}
