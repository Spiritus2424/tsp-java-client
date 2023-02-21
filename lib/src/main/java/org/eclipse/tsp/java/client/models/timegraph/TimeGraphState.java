package org.eclipse.tsp.java.client.models.timegraph;

import java.math.BigInteger;

import org.eclipse.tsp.java.client.models.style.OutputElementStyle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeGraphState {
    @NonNull
    private BigInteger start;
    @NonNull
    private BigInteger end;
    private String label;
    private int tags;
    private OutputElementStyle style;
}
