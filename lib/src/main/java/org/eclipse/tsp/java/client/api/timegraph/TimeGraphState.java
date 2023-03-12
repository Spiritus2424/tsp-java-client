package org.eclipse.tsp.java.client.api.timegraph;

import java.math.BigInteger;

import org.eclipse.tsp.java.client.api.style.OutputElementStyle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class TimeGraphState {
    @NonNull
    private BigInteger start;
    @NonNull
    private BigInteger end;
    private String label;
    private int tags;
    private OutputElementStyle style;
}
