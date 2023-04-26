package org.eclipse.tsp.java.client.api.style;

import java.util.Optional;
import java.util.UUID;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;

public class StyleApi extends AbstractTspApi {
	private final String STYLE_API_URL;

	public StyleApi(String baseUrl) {
		super(baseUrl);
		this.STYLE_API_URL = this.getBaseUrl().concat("/experiments/%s/outputs/%s/style");
	}

	@Async
	public TspClientResponse<GenericResponse<OutputStyleModel>> getStyles(UUID experimentUuid, String outputId,
			Query query) {
		return this.getRestClientSingleton().post(String.format(this.STYLE_API_URL, experimentUuid, outputId),
				Optional.of(query),
				this.getTypeFactory().constructParametricType(GenericResponse.class, OutputStyleModel.class));
	}
}
