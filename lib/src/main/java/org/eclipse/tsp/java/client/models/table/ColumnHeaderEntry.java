package org.eclipse.tsp.java.client.models.table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class ColumnHeaderEntry {
    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private String type;
}
