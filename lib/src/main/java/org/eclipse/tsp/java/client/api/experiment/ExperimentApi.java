package org.eclipse.tsp.java.client.api.experiment;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.api.experiment.dto.CreateExperimentRequestDto;
import org.eclipse.tsp.java.client.api.experiment.dto.UpdateExperimentRequestDto;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLogBuilder;

public class ExperimentApi extends AbstractTspApi {
	private final @NonNull Logger logger;
	private final String EXPERIMENT_API_URL;

	public ExperimentApi(String baseUrl) {
		super(baseUrl);
		this.logger = TraceCompassLog.getLogger(ExperimentApi.class);
		this.EXPERIMENT_API_URL = this.getBaseUrl().concat("/experiments");
	}

	@Async
	public TspClientResponse<List<Experiment>> getExperiments(final Optional<Map<String, String>> queryParameters) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"ExperimentApi#getExperiments").build()) {
			return this.getRestClientSingleton().get(this.EXPERIMENT_API_URL,
					queryParameters,
					this.getTypeFactory().constructCollectionType(List.class, Experiment.class));

		}
	}

	@Async
	public TspClientResponse<Experiment> getExperiment(final UUID experimentUuid) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"ExperimentApi#getExperiment").build()) {
			return this.getRestClientSingleton().get(
					String.format(this.EXPERIMENT_API_URL.concat("/%s"), experimentUuid),
					Optional.empty(),
					this.getTypeFactory().constructType(Experiment.class));
		}

	}

	@Async
	public TspClientResponse<Experiment> createExperiment(final Body<CreateExperimentRequestDto> body) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"ExperimentApi#createExperiment").build()) {
			return this.getRestClientSingleton().post(this.EXPERIMENT_API_URL,
					Optional.of(body),
					Optional.empty(),
					this.getTypeFactory().constructType(Experiment.class));
		}

	}

	@Async
	public TspClientResponse<Experiment> updateExperiment(
			final UUID experimentUuid,
			final Body<UpdateExperimentRequestDto> body) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"ExperimentApi#updateExperiment").build()) {
			return this.getRestClientSingleton().put(this.EXPERIMENT_API_URL,
					Optional.of(body),
					Optional.empty(),
					this.getTypeFactory().constructType(Experiment.class));
		}
	}

	@Async
	public TspClientResponse<Experiment> deleteExperiment(final UUID experimentUuid) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"ExperimentApi#deleteExperiment").build()) {
			return this.getRestClientSingleton().delete(
					String.format(this.EXPERIMENT_API_URL.concat("/%s"), experimentUuid),
					Optional.empty(),
					this.getTypeFactory().constructType(Experiment.class));
		}
	}

}
