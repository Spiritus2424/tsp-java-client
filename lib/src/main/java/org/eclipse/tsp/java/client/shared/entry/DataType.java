package org.eclipse.tsp.java.client.shared.entry;

public enum DataType {
	/**
	 * Data represent a decimal number
	 */
	NUMBER,
	/**
	 * Binary data, where the size orders are powers of 2.
	 */
	BINARY_NUMBER,
	/**
	 * Data represent a timestamp in nanoseconds, can be negative
	 */
	TIMESTAMP,
	/**
	 * Data represents a duration
	 */
	DURATION,
	/**
	 * Data is textual data
	 */
	STRING,
	/**
	 * Data representing a time range of string: [start,end],
	 * where `start` and `end` are timestamps in nanoseconds
	 */
	TIME_RANGE;
}
