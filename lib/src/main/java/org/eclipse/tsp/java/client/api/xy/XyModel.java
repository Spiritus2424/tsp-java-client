package org.eclipse.tsp.java.client.api.xy;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
// @NoArgsConstructor
public class XyModel {
    @NonNull
    private String title;
    @NonNull
    private List<XySerie> series;

    public XyModel() {
        this.series = new ArrayList<>();
    }

}
