package org.eclipse.tsp.java.client.models.experiment;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import org.eclipse.tsp.java.client.models.indexing.IndexingStatus;
import org.eclipse.tsp.java.client.models.trace.Trace;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Experiment {
    @JsonProperty("UUID")
    @EqualsAndHashCode.Include
    @NonNull
    private UUID uuid;
    @NonNull
    private String name;
    @NonNull
    private BigInteger start;
    @NonNull
    private BigInteger end;
    @NonNull
    private int nbEvents;
    @NonNull
    private IndexingStatus indexingStatus;
    @NonNull
    private List<Trace> traces;

}
