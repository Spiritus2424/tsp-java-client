package org.eclipse.tsp.java.client.api.timegraph;

import java.math.BigInteger;

import org.eclipse.tsp.java.client.shared.entry.Entry;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@NoArgsConstructor
public class TimeGraphEntry extends Entry {
    @NonNull
    private BigInteger start;
    @NonNull
    private BigInteger end;

}
