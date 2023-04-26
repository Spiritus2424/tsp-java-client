package org.eclipse.tsp.java.client.api.experiment;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Query;

public class ExperimentApi extends AbstractTspApi {
	final String EXPERIMENT_API_URL = "%s/experiments";

	public ExperimentApi(String baseUrl) {
		super(baseUrl);
	}

	@Async
	public TspClientResponse<List<Experiment>> getExperiments(Optional<Map<String, String>> queryParameters) {
		return this.getRestClientSingleton().get(String.format(this.EXPERIMENT_API_URL, this.getBaseUrl()),
				queryParameters,
				this.getTypeFactory().constructCollectionType(List.class, Experiment.class));
	}

	@Async
	public TspClientResponse<Experiment> getExperiment(UUID experimentUuid) {
		return this.getRestClientSingleton().get(
				String.format(this.EXPERIMENT_API_URL.concat("/%s"), this.getBaseUrl(), experimentUuid),
				Optional.empty(), this.getTypeFactory().constructType(Experiment.class));
	}

	@Async
	public TspClientResponse<Experiment> createExperiment(Query query) {
		return this.getRestClientSingleton().post(String.format(this.EXPERIMENT_API_URL, this.getBaseUrl()),
				Optional.of(query), this.getTypeFactory().constructType(Experiment.class));
	}

	@Async
	public TspClientResponse<Experiment> updateExperiment(UUID experimentUuid, Query query) {
		return this.getRestClientSingleton().put(String.format(this.EXPERIMENT_API_URL, this.getBaseUrl()),
				Optional.of(query), this.getTypeFactory().constructType(Experiment.class));
	}

	@Async
	public TspClientResponse<Experiment> deleteExperiment(UUID experimentUuid) {
		return this.getRestClientSingleton().delete(
				String.format(this.EXPERIMENT_API_URL.concat("/%s"), this.getBaseUrl(), experimentUuid),
				Optional.empty(),
				this.getTypeFactory().constructType(Experiment.class));
	}

}
