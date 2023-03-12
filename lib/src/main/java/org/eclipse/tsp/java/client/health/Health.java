package org.eclipse.tsp.java.client.health;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Health {
    @NonNull
    private HealthStatus status;
}
