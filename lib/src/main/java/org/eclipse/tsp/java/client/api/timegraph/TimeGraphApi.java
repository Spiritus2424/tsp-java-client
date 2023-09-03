package org.eclipse.tsp.java.client.api.timegraph;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.api.timegraph.dto.GetTimeGraphArrowsRequestDto;
import org.eclipse.tsp.java.client.api.timegraph.dto.GetTimeGraphStatesRequestDto;
import org.eclipse.tsp.java.client.api.timegraph.dto.GetTimeGraphTooltipsRequestDto;
import org.eclipse.tsp.java.client.api.timegraph.dto.GetTimeGraphTreeRequestDto;
import org.eclipse.tsp.java.client.core.action.ActionDescriptor;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.entry.EntryModel;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;

public class TimeGraphApi extends AbstractTspApi {
	private final String TIME_GRAPH_API_URL;

	public TimeGraphApi(String baseUrl) {
		super(baseUrl);
		this.TIME_GRAPH_API_URL = this.getBaseUrl().concat("/experiments/%s/outputs/timeGraph/%s");
	}

	@Async
	public TspClientResponse<GenericResponse<List<TimeGraphArrow>>> getTimeGraphArrows(
			final UUID experimentUuid,
			final String outputId,
			final Body<GetTimeGraphArrowsRequestDto> body) {
		return this.getRestClientSingleton()
				.post(String.format(this.TIME_GRAPH_API_URL.concat("/arrows"), experimentUuid, outputId),
						Optional.of(body),
						Optional.empty(),
						this.getTypeFactory().constructParametricType(GenericResponse.class,
								this.getTypeFactory().constructCollectionType(List.class,
										TimeGraphArrow.class)));
	}

	@Async
	public TspClientResponse<GenericResponse<TimeGraphModel>> getTimeGraphStates(
			final UUID experimentUuid,
			final String outputId,
			final Body<GetTimeGraphStatesRequestDto> body) {
		return this.getRestClientSingleton()
				.post(String.format(this.TIME_GRAPH_API_URL.concat("/states"), experimentUuid, outputId),
						Optional.of(body),
						Optional.empty(),
						this.getTypeFactory().constructParametricType(GenericResponse.class, TimeGraphModel.class));
	}

	@Async
	public TspClientResponse<GenericResponse<Map<String, String>>> getTimeGraphTooltips(
			final UUID experimentUuid,
			final String outputId,
			final Body<GetTimeGraphTooltipsRequestDto> body) {
		return this.getRestClientSingleton()
				.post(String.format(this.TIME_GRAPH_API_URL.concat("/tooltip"), experimentUuid, outputId),
						Optional.of(body),
						Optional.empty(),
						this.getTypeFactory().constructParametricType(GenericResponse.class,
								this.getTypeFactory().constructMapType(Map.class, String.class, String.class)));
	}

	@Async
	public TspClientResponse<GenericResponse<EntryModel<TimeGraphEntry>>> getTimeGraphTree(
			final UUID experimentUuid,
			final String outputId,
			final Body<GetTimeGraphTreeRequestDto> body) {
		return this.getRestClientSingleton()
				.post(String.format(this.TIME_GRAPH_API_URL.concat("/tree"), experimentUuid, outputId),
						Optional.of(body),
						Optional.empty(),
						this.getTypeFactory().constructParametricType(GenericResponse.class,
								this.getTypeFactory().constructParametricType(EntryModel.class,
										TimeGraphEntry.class)));
	}

	@Async
	public TspClientResponse<GenericResponse<List<ActionDescriptor>>> getTimeGraphActionTooltips(
			final UUID experimentUuid,
			final String outputId,
			final Body<GetTimeGraphTooltipsRequestDto> body) {
		return this.getRestClientSingleton()
				.post(String.format(this.TIME_GRAPH_API_URL.concat("/tooltip/actions"), experimentUuid, outputId),
						Optional.of(body),
						Optional.empty(),
						this.getTypeFactory().constructParametricType(GenericResponse.class, this.getTypeFactory()
								.constructCollectionType(List.class, ActionDescriptor.class)));
	}

	@Async
	public TspClientResponse<Void> applyTimeGraphActionTooltip(
			final UUID experimentUuid,
			final String outputId,
			final String actionId,
			final Body<Map<String, Object>> body) {
		return this.getRestClientSingleton()
				.post(String.format(this.TIME_GRAPH_API_URL.concat("/tooltip/actions/%s"), experimentUuid, outputId,
						actionId),
						Optional.of(body),
						Optional.empty(),
						this.getTypeFactory().constructType(Void.class));
	}
}
