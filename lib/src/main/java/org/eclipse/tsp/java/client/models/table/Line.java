package org.eclipse.tsp.java.client.models.table;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Line {
    @NonNull
    private int index;
    @NonNull
    private List<Cell> cells;
    private int tags;

}
