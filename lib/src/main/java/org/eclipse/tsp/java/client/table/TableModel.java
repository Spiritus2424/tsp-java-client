package org.eclipse.tsp.java.client.table;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class TableModel {
    @NonNull
    private int lowIndex;
    @NonNull
    private int size;
    @NonNull
    private List<Integer> columnIds;
    @NonNull
    private List<Line> lines;

}
