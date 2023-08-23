package org.eclipse.tsp.java.client.api.graph;

public enum ProcessStatus {
	/** Unknown process status */
	UNKNOWN,
	/** Waiting for a fork */
	WAIT_FORK,
	/** Waiting for the CPU */
	WAIT_CPU,
	/**
	 * The thread has exited, but is not dead yet
	 */
	EXIT,
	/** The thread is a zombie thread */
	ZOMBIE,
	/** The thread is blocked */
	WAIT_BLOCKED,
	/** The thread is running */
	RUN,
	/** The thread is dead or hasn't started yet */
	NOT_ALIVE,
	/** The thread is running in system call */
	RUN_SYTEMCALL,
	/** The thread is running but interrupted */
	INTERRUPTED,
	/** Waiting for an unknown reason */
	WAIT_UNKNOWN
}
