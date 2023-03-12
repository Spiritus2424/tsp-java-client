package org.eclipse.tsp.java.client.filter;

import java.util.List;

import org.eclipse.tsp.java.client.tspapi.AbstractTspApi;

public class FilterApi extends AbstractTspApi {
    private final String FILTER_API_URL = "%s/filters";

    public FilterApi(String baseUrl) {
        super(baseUrl);
    }

    public List<Filter> getFilters() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    public Filter getFilter(String filterId) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    public Filter createFilter(Filter filter) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    public Filter updateFilter(String filterId, Filter filter) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    public Filter deleteFilter(String filterId) {
        throw new UnsupportedOperationException("Not Implemented");
    }
}
