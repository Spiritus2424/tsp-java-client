package org.eclipse.tsp.java.client.models.xy;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
// @NoArgsConstructor
public class XYModel {
    @NonNull
    private String title;
    @NonNull
    private List<XYSerie> series;

    public XYModel() {
        this.series = new ArrayList<>();
    }

}
