package org.eclipse.tsp.java.client.models.timegraph;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class TimeGraphRow {
    @NonNull
    private int entryId;
    @NonNull
    private List<TimeGraphState> states;
}
