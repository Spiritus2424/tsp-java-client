package org.eclipse.tsp.java.client.api.bookmark;

import java.math.BigInteger;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@NoArgsConstructor
public class Bookmark {

    @EqualsAndHashCode.Include
    @NonNull
    private UUID uuid;
    @NonNull
    private String name;
    @NonNull
    private BigInteger startTime;
    @NonNull
    private BigInteger endTime;
    @NonNull
    private String type;

}
