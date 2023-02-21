package org.eclipse.tsp.java.client.models.filter;

import java.math.BigInteger;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Filter {
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private BigInteger startTime;
    @NonNull
    private BigInteger endTime;
    @NonNull
    private String expression;
    @NonNull
    private int tags;

}
