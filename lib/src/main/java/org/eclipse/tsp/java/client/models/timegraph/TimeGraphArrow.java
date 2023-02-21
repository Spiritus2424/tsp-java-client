package org.eclipse.tsp.java.client.models.timegraph;

import java.math.BigInteger;

import org.eclipse.tsp.java.client.models.style.OutputElementStyle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class TimeGraphArrow {
    @NonNull
    private int sourceId;
    @NonNull
    private int targetId;
    @NonNull
    private BigInteger start;
    @NonNull
    private BigInteger end;
    private OutputElementStyle style;

}
