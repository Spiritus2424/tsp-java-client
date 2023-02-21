package org.eclipse.tsp.java.client.models.style;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class OutputStyleModel {
    @NonNull
    private Map<String, OutputElementStyle> styles;

}
