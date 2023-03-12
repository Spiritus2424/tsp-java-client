package org.eclipse.tsp.java.client.experiment;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.restclient.RestClient;
import org.eclipse.tsp.java.client.shared.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.tspapi.AbstractTspApi;

public class ExperimentApi extends AbstractTspApi {
    final String EXPERIMENT_API_URL = "%s/experiments";

    public ExperimentApi(String baseUrl) {
        super(baseUrl);
    }

    public TspClientResponse<Experiment[]> getExperiments(Optional<Map<String, String>> queryParameters) {
        return RestClient.get(String.format(this.EXPERIMENT_API_URL, this.getBaseUrl()), queryParameters,
                Experiment[].class);
    }

    public TspClientResponse<Experiment> getExperiment(UUID experimentUuid) {
        return RestClient.get(
                String.format(this.EXPERIMENT_API_URL.concat("/%s"), this.getBaseUrl(), experimentUuid),
                Optional.empty(),
                Experiment.class);
    }

    public TspClientResponse<Experiment> createExperiment(Query query) {
        return RestClient.post(String.format(this.EXPERIMENT_API_URL, this.getBaseUrl()), Optional.of(query),
                Experiment.class);
    }

    public TspClientResponse<Experiment> updateExperiment(UUID experimentUuid, Query query) {
        return RestClient.put(String.format(this.EXPERIMENT_API_URL, this.getBaseUrl()), Optional.of(query),
                Experiment.class);
    }

    public TspClientResponse<Experiment> deleteExperiment(UUID experimentUuid) {
        return RestClient.delete(
                String.format(this.EXPERIMENT_API_URL.concat("/%s"), this.getBaseUrl(), experimentUuid),
                Optional.empty(),
                Experiment.class);
    }

}
