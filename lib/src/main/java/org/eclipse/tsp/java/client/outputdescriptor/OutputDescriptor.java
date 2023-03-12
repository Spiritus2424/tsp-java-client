package org.eclipse.tsp.java.client.outputdescriptor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class OutputDescriptor {
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private OutputDescriptorType type;

    private Map<String, Object> queryParameters;
    private BigInteger start;
    private BigInteger end;
    private boolean isFinal;
    private ArrayList<String> compatibleProviders;
}
