package org.eclipse.tsp.java.client.models.query;

import java.math.BigInteger;
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

    public static Query timeQuery(List<BigInteger> requestedTimes, Map<String, Object> additionalProperties) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put(REQUESTED_TIMES_KEY, requestedTimes);
        parameters.putAll(additionalProperties);
        return new Query(parameters);
    }

    public static Query selectionTimeQuery(List<BigInteger> requestedTimes, List<Integer> number,
            Map<String, Object> additionalProperties) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put(REQUESTED_TIMES_KEY, requestedTimes);
        parameters.put(REQUESTED_ITEMS_KEY, requestedTimes);
        parameters.putAll(additionalProperties);
        return new Query(parameters);
    }

    public static Query timeRangeQuery(BigInteger start, BigInteger end,
            Optional<Map<String, Object>> additionalProperties) {
        return timeRangeQuery(start, end, Optional.empty(), additionalProperties);
    }

    public static Query timeRangeQuery(BigInteger start, BigInteger end,
            Optional<Integer> nbTimes,
            Optional<Map<String, Object>> additionalProperties) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put(REQUESTED_TIMERANGE_KEY, nbTimes.isPresent() ? new QueryInterval(start, end, nbTimes.get())
                : new QueryInterval(start, end));
        if (additionalProperties.isPresent()) {
            parameters.putAll(additionalProperties.get());
        }

        return new Query(parameters);
    }

    public static Query selectionTimeRangeQuery(BigInteger start, BigInteger end, int nbTimes, List<Integer> items,
            Optional<Map<String, Object>> additionalProperties) {
        return selectionTimeRangeQuery(start, end, Optional.of(nbTimes), Optional.of(items), additionalProperties);
    }

    public static Query selectionTimeRangeQuery(BigInteger start, BigInteger end, Optional<Integer> nbTimes,
            Optional<List<Integer>> items,
            Optional<Map<String, Object>> additionalProperties) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put(REQUESTED_TIMERANGE_KEY, nbTimes.isPresent() ? new QueryInterval(start, end, nbTimes.get())
                : new QueryInterval(start, end));

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

    public static List<BigInteger> splitRangeIntoEqualParts(BigInteger start, BigInteger end, int size) {

        if (start.compareTo(end) == 1) {
            final BigInteger temp = end;
            end = start;
            start = temp;
        }

        if (size == 0) {
            return new ArrayList<BigInteger>();
        } else if (size == 1) {
            return new ArrayList<BigInteger>(List.of(start));
        }

        size = Math.min(size, end.subtract(start).add(BigInteger.ONE).intValue());

        final List<BigInteger> result = new ArrayList<>(size);
        final int stepSize = Math.max(1, end.subtract(start).divide(BigInteger.valueOf(size - 1)).intValue());

        for (int i = 0; i < size; i++) {
            result.set(i, start.add(BigInteger.valueOf(i * stepSize)));
        }

        result.set(result.size() - 1, end);
        return result;
    }
}
