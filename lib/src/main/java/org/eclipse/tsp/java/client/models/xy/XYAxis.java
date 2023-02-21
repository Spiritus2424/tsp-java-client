package org.eclipse.tsp.java.client.models.xy;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class XYAxis {
    @NonNull
    private String label;
    @NonNull
    private String unit;
    @NonNull
    private String dataType;

}
