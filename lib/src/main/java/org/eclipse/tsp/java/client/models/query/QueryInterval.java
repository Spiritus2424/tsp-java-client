package org.eclipse.tsp.java.client.models.query;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class QueryInterval {
    @NonNull
    private BigInteger start;
    @NonNull
    private BigInteger end;
    private int nbTimes;

}
