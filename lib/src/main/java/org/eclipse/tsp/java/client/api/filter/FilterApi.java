package org.eclipse.tsp.java.client.api.filter;

import java.util.List;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;

public class FilterApi extends AbstractTspApi {
	private final String FILTER_API_URL;

	public FilterApi(String baseUrl) {
		super(baseUrl);
		this.FILTER_API_URL = this.getBaseUrl().concat("/filters");
	}

	@Async
	public List<Filter> getFilters() {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Async
	public Filter getFilter(String filterId) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Async
	public Filter createFilter(Filter filter) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Async
	public Filter updateFilter(String filterId, Filter filter) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Async
	public Filter deleteFilter(String filterId) {
		throw new UnsupportedOperationException("Not Implemented");
	}
}
