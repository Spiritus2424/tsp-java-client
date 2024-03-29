package org.eclipse.tsp.java.client.api.xy;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class XyAxis {
    @NonNull
    private String label;
    @NonNull
    private String unit;
    @NonNull
    private String dataType;

}
