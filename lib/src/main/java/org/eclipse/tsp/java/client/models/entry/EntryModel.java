package org.eclipse.tsp.java.client.models.entry;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class EntryModel<T> {
    @NonNull
    private List<EntryHeader> headers;
    @NonNull
    private List<T> entries;

}
