package org.eclipse.tsp.java.client.table;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Line {
    @NonNull
    private int index;
    @NonNull
    private List<Cell> cells;
    private int tags;

}
