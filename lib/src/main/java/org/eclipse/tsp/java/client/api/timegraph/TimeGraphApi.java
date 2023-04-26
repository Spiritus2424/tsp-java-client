package org.eclipse.tsp.java.client.api.timegraph;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.api.timegraph.dto.TimeGraphArrowRequestDto;
import org.eclipse.tsp.java.client.api.timegraph.dto.TimeGraphStateRequestDto;
import org.eclipse.tsp.java.client.api.timegraph.dto.TimeGraphTreeRequestDto;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.entry.EntryModel;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;

public class TimeGraphApi extends AbstractTspApi {
	private final String TIME_GRAPH_API_URL = "%s/experiments/%s/outputs/timeGraph/%s";

	public TimeGraphApi(String baseUrl) {
		super(baseUrl);
	}

	@Async
	public TspClientResponse<GenericResponse<List<TimeGraphArrow>>> getTimeGraphArrows(UUID experimentUuid,
			String outputId, Body<TimeGraphArrowRequestDto> body) {
		return this.getRestClientSingleton()
				.post(String.format(this.TIME_GRAPH_API_URL.concat("/arrows"), this.getBaseUrl(), experimentUuid,
						outputId),
						Optional.of(body),
						this.getTypeFactory().constructParametricType(GenericResponse.class,
								this.getTypeFactory().constructCollectionType(List.class,
										TimeGraphArrow.class)));
	}

	@Async
	public TspClientResponse<GenericResponse<TimeGraphModel>> getTimeGraphStates(UUID experimentUuid,
			String outputId,
			Body<TimeGraphStateRequestDto> body) {
		return this.getRestClientSingleton()
				.post(String.format(this.TIME_GRAPH_API_URL.concat("/states"), this.getBaseUrl(), experimentUuid,
						outputId),
						Optional.of(body),
						this.getTypeFactory().constructParametricType(GenericResponse.class, TimeGraphModel.class));
	}

	@Async
	public TspClientResponse<GenericResponse<Map<String, String>>> getTimeGraphTooltip(UUID experimentUuid,
			String outputIdclass XyModelRequestDto,
			Body<TimeGraphTooltipRequestDto> body) {
		return this.getRestClientSingleton()
				.post(String.format(this.TIME_GRAPH_API_URL.concat("/tooltip"), this.getBaseUrl(), experimentUuid,
						outputId),
						Optional.of(body),
						this.getTypeFactory().constructParametricType(GenericResponse.class,
								this.getTypeFactory().constructMapType(Map.class, String.class, String.class)));
	}

	@Async
	public TspClientResponse<GenericResponse<EntryModel<TimeGraphEntry>>> getTimeGraphTree(UUID experimentUuid,
			String outputId, Body<TimeGraphTreeRequestDto> body) {
		return this.getRestClientSingleton()
				.post(String.format(this.TIME_GRAPH_API_URL.concat("/tree"), this.getBaseUrl(), experimentUuid,
						outputId),
						Optional.of(body),
						this.getTypeFactory().constructParametricType(GenericResponse.class,
								this.getTypeFactory().constructParametricType(EntryModel.class,
										TimeGraphEntry.class)));
	}
}
