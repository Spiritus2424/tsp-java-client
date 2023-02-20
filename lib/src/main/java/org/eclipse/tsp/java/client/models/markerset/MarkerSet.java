package org.eclipse.tsp.java.client.models.markerset;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class MarkerSet {
    @NonNull
    private String name;
    @NonNull
    private String id;

}
