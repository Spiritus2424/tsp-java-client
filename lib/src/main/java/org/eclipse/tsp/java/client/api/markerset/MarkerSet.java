package org.eclipse.tsp.java.client.api.markerset;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class MarkerSet {
    @NonNull
    private String name;
    @NonNull
    private String id;

}
