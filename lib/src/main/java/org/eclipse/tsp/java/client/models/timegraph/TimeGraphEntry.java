package org.eclipse.tsp.java.client.models.timegraph;

import java.math.BigInteger;

import org.eclipse.tsp.java.client.models.entry.Entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TimeGraphEntry extends Entry {
    @NonNull
    private BigInteger start;
    @NonNull
    private BigInteger end;

}
