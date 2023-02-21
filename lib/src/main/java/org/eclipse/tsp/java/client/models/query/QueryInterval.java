package org.eclipse.tsp.java.client.models.query;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryInterval {
    @NonNull
    private BigInteger start;
    @NonNull
    private BigInteger end;
    private int nbTimes;

}
