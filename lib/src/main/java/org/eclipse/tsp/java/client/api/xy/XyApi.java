package org.eclipse.tsp.java.client.api.xy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.api.xy.dto.GetXyModelRequestDto;
import org.eclipse.tsp.java.client.api.xy.dto.GetXyTreeRequestDto;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.entry.Entry;
import org.eclipse.tsp.java.client.shared.entry.EntryModel;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLogBuilder;

public class XyApi extends AbstractTspApi {
	private final @NonNull Logger logger;
	private final String XY_API_URL;

	public XyApi(String baseUrl) {
		super(baseUrl);
		this.logger = TraceCompassLog.getLogger(XyApi.class);
		this.XY_API_URL = this.getBaseUrl().concat("/experiments/%s/outputs/XY/%s");
	}

	@Async
	public TspClientResponse<GenericResponse<EntryModel<Entry>>> getXyTree(
			final UUID experimentUuid,
			final String outputId,
			final Body<GetXyTreeRequestDto> body) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"XyApi#getXyTree").setCategory(outputId).build()) {
			return this.getRestClientSingleton().post(
					String.format(this.XY_API_URL.concat("/tree"), experimentUuid, outputId),
					Optional.of(body),
					Optional.empty(),
					this.getTypeFactory().constructParametricType(GenericResponse.class,
							this.getTypeFactory().constructParametricType(EntryModel.class,
									Entry.class)));
		}
	}

	@Async
	public TspClientResponse<GenericResponse<XyModel>> getXy(
			final UUID experimentUuid,
			final String outputId,
			final Body<GetXyModelRequestDto> body) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"XyApi#getXyTree").setCategory(outputId).build()) {
			return this.getRestClientSingleton().post(
					String.format(this.XY_API_URL.concat("/xy"), experimentUuid, outputId),
					Optional.of(body),
					Optional.empty(),
					this.getTypeFactory().constructParametricType(GenericResponse.class, XyModel.class));
		}
	}

	@Async
	public TspClientResponse<GenericResponse<Map<String, String>>> getXyTooltips(
			final UUID experimentUuid,
			final String outputId,
			final int xValue,
			final Optional<Integer> yValue,
			final Optional<String> seriesId) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"XyApi#getXyTree").setCategory(outputId).build()) {
			Map<String, String> queryParameters = new HashMap<String, String>();
			if (yValue.isPresent()) {
				queryParameters.put("yValue", yValue.get().toString());
			}

			if (seriesId.isPresent()) {
				queryParameters.put("seriesId", seriesId.get().toString());
			}

			return this.getRestClientSingleton().get(
					String.format(this.XY_API_URL.concat("/tooltip"), experimentUuid, outputId),
					Optional.of(queryParameters),
					this.getTypeFactory().constructParametricType(GenericResponse.class,
							this.getTypeFactory().constructMapType(Map.class, String.class, String.class)));
		}

	}

}
