package org.eclipse.tsp.java.client.models.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cell {
    @NonNull
    private String content;
    private int tags;

}
