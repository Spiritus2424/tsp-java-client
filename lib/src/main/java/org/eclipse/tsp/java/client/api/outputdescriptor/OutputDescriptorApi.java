package org.eclipse.tsp.java.client.api.outputdescriptor;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;

public class OutputDescriptorApi extends AbstractTspApi {
	private final String OUTPUT_DESCRIPTOR_API_URL;

	public OutputDescriptorApi(String baseUrl) {
		super(baseUrl);
		this.OUTPUT_DESCRIPTOR_API_URL = this.getBaseUrl().concat("/experiments/%s/outputs");
	}

	@Async
	public TspClientResponse<List<OutputDescriptor>> experimentOutputs(
			final UUID experimentUuid,
			final Optional<Map<String, String>> queryParameters) {
		return this.getRestClientSingleton().get(String.format(this.OUTPUT_DESCRIPTOR_API_URL, experimentUuid),
				queryParameters,
				this.getTypeFactory().constructCollectionType(List.class, OutputDescriptor.class));
	}

}
