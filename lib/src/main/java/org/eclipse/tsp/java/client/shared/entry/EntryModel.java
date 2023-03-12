package org.eclipse.tsp.java.client.shared.entry;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class EntryModel<T> {
    @NonNull
    private List<EntryHeader> headers;
    @NonNull
    private List<T> entries;

}
