package org.eclipse.tsp.java.client.api.markerset;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;

public class MarkerSetApi extends AbstractTspApi {
	private final String MARKER_SET_API_URL;

	public MarkerSetApi(String baseUrl) {
		super(baseUrl);
		this.MARKER_SET_API_URL = this.getBaseUrl().concat("/experiments/%s/outputs/markerSets");
	}

	@Async
	public TspClientResponse<GenericResponse<Set<MarkerSet>>> getMarkerSets(UUID experimentUuid) {
		return this.getRestClientSingleton().get(String.format(this.MARKER_SET_API_URL, experimentUuid),
				Optional.empty(),
				this.getTypeFactory().constructParametricType(GenericResponse.class,
						this.getTypeFactory().constructCollectionType(Set.class, MarkerSet.class)));
	}

}
