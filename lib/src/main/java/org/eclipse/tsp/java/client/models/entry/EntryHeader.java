package org.eclipse.tsp.java.client.models.entry;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class EntryHeader {
    @NonNull
    private String name;
    @NonNull
    private String tooltip;

}
