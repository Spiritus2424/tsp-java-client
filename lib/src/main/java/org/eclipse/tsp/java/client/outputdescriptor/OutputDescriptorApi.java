package org.eclipse.tsp.java.client.outputdescriptor;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.tsp.java.client.shared.restclient.RestClient;
import org.eclipse.tsp.java.client.shared.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.tspapi.AbstractTspApi;

public class OutputDescriptorApi extends AbstractTspApi {
    private final String OUTPUT_DESCRIPTOR_API_URL = "%s/experiments/%s/outputs";

    public OutputDescriptorApi(String baseUrl) {
        super(baseUrl);
    }

    public TspClientResponse<OutputDescriptor[]> experimentOutputs(UUID experimentUuid,
            Optional<Map<String, String>> queryParameters) {
        return RestClient.get(String.format(this.OUTPUT_DESCRIPTOR_API_URL, this.getBaseUrl(), experimentUuid),
                queryParameters, OutputDescriptor[].class);
    }

}
