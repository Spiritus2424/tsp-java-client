package org.eclipse.tsp.java.client.shared.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class QueryHelper {

	private static final String REQUESTED_TIMES_KEY = "requested_times";

	private static final String REQUESTED_TIMERANGE_KEY = "requested_timerange";

	private static final String REQUESTED_ITEMS_KEY = "requested_items";

	private static final String REQUESTED_ELEMENT_KEY = "requested_element";

	private static final String REQUESTED_TABLE_INDEX_KEY = "requested_table_index";

	private static final String REQUESTED_TABLE_COUNT_KEY = "requested_table_count";

	private static final String REQUESTED_TABLE_COLUMN_IDS_KEY = "requested_table_column_ids";

	public static Query query(Map<String, Object> additionalProperties) {
		return new Query(additionalProperties);
	}

	public static Query timeQuery(List<Long> requestedTimes, Map<String, Object> additionalProperties) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(REQUESTED_TIMES_KEY, requestedTimes);
		parameters.putAll(additionalProperties);
		return new Query(parameters);
	}

	public static Query selectionTimeQuery(List<Long> requestedTimes, List<Integer> number,
			Map<String, Object> additionalProperties) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(REQUESTED_TIMES_KEY, requestedTimes);
		parameters.put(REQUESTED_ITEMS_KEY, requestedTimes);
		parameters.putAll(additionalProperties);
		return new Query(parameters);
	}

	public static Query timeRangeQuery(long start, long end,
			Optional<Map<String, Object>> additionalProperties) {
		return timeRangeQuery(start, end, Optional.empty(), additionalProperties);
	}

	public static Query timeRangeQuery(long start, long end,
			Optional<Integer> nbTimes,
			Optional<Map<String, Object>> additionalProperties) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(REQUESTED_TIMERANGE_KEY, nbTimes.isPresent() ? new QueryInterval(start, end, nbTimes.get())
				: new QueryInterval(start, end, 0));
		if (additionalProperties.isPresent()) {
			parameters.putAll(additionalProperties.get());
		}

		return new Query(parameters);
	}

	public static Query selectionTimeRangeQuery(long start, long end, int nbTimes, List<Integer> items,
			Optional<Map<String, Object>> additionalProperties) {
		return selectionTimeRangeQuery(start, end, Optional.of(nbTimes), Optional.of(items), additionalProperties);
	}

	public static Query selectionTimeRangeQuery(long start, long end, Optional<Integer> nbTimes,
			Optional<List<Integer>> items,
			Optional<Map<String, Object>> additionalProperties) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(REQUESTED_TIMERANGE_KEY, nbTimes.isPresent() ? new QueryInterval(start, end, nbTimes.get())
				: new QueryInterval(start, end, 0));

		if (items.isPresent()) {
			parameters.put(REQUESTED_ITEMS_KEY, items.get());
		}

		if (additionalProperties.isPresent()) {
			parameters.putAll(additionalProperties.get());
		}

		return new Query(parameters);
	}

	public static Query tableQuery(List<Integer> columnsId, int index, int count,
			Optional<Map<String, Object>> additionalProperties) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(REQUESTED_TABLE_COLUMN_IDS_KEY, columnsId);
		parameters.put(REQUESTED_TABLE_INDEX_KEY, index);
		parameters.put(REQUESTED_TABLE_COUNT_KEY, count);
		if (additionalProperties.isPresent()) {
			parameters.putAll(additionalProperties.get());
		}
		return new Query(parameters);
	}

	public static List<Long> splitRangeIntoEqualParts(Long start, Long end, int size) {

		if (start.compareTo(end) == 1) {
			final Long temp = end;
			end = start;
			start = temp;
		}

		if (size == 0) {
			return new ArrayList<Long>();
		} else if (size == 1) {
			return new ArrayList<Long>(List.of(start));
		}

		size = Math.min(size, Long.valueOf(end - start + 1).intValue());

		final List<Long> result = new ArrayList<>(size);
		final int stepSize = Math.max(1, Long.valueOf(end - start).intValue() / (size - 1));

		for (int i = 0; i < size; i++) {
			result.set(i, start + Long.valueOf(i * stepSize));
		}

		result.set(result.size() - 1, end);
		return result;
	}
}
