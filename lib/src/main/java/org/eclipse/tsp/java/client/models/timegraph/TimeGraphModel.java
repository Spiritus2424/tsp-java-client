package org.eclipse.tsp.java.client.models.timegraph;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class TimeGraphModel {
    @NonNull
    private List<TimeGraphRow> rows;
}
