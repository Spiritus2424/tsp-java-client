package org.eclipse.tsp.java.client.models.bookmark;

import java.math.BigInteger;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
