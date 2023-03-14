package org.eclipse.tsp.java.client.shared.entry;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class EntryHeader {
    @NonNull
    private String name;
    @NonNull
    private String tooltip;

}
