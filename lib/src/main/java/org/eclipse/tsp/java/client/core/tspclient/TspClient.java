package org.eclipse.tsp.java.client.core.tspclient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.tsp.java.client.api.annotation.AnnotationApi;
import org.eclipse.tsp.java.client.api.annotation.AnnotationApiAsync;
import org.eclipse.tsp.java.client.api.bookmark.BookmarkApi;
import org.eclipse.tsp.java.client.api.bookmark.BookmarkApiAsync;
import org.eclipse.tsp.java.client.api.experiment.ExperimentApi;
import org.eclipse.tsp.java.client.api.experiment.ExperimentApiAsync;
import org.eclipse.tsp.java.client.api.filter.FilterApi;
import org.eclipse.tsp.java.client.api.filter.FilterApiAsync;
import org.eclipse.tsp.java.client.api.health.HealthApi;
import org.eclipse.tsp.java.client.api.health.HealthApiAsync;
import org.eclipse.tsp.java.client.api.markerset.MarkerSetApi;
import org.eclipse.tsp.java.client.api.markerset.MarkerSetApiAsync;
import org.eclipse.tsp.java.client.api.outputdescriptor.OutputDescriptorApi;
import org.eclipse.tsp.java.client.api.outputdescriptor.OutputDescriptorApiAsync;
import org.eclipse.tsp.java.client.api.style.StyleApi;
import org.eclipse.tsp.java.client.api.style.StyleApiAsync;
import org.eclipse.tsp.java.client.api.table.TableApi;
import org.eclipse.tsp.java.client.api.table.TableApiAsync;
import org.eclipse.tsp.java.client.api.timegraph.TimeGraphApi;
import org.eclipse.tsp.java.client.api.timegraph.TimeGraphApiAsync;
import org.eclipse.tsp.java.client.api.trace.TraceApi;
import org.eclipse.tsp.java.client.api.trace.TraceApiAsync;
import org.eclipse.tsp.java.client.api.xy.XyApi;
import org.eclipse.tsp.java.client.api.xy.XyApiAsync;

import lombok.Getter;

public class TspClient {

	/*
	 * Annotation Api
	 */
	@Getter
	private AnnotationApi annotationApi;
	@Getter
	private AnnotationApiAsync annotationApiAsync;
	/*
	 * Bookmark Api
	 */
	@Getter
	private BookmarkApi bookmarkApi;
	@Getter
	private BookmarkApiAsync bookmarkApiAsync;
	/*
	 * Experiment Api
	 */
	@Getter
	private ExperimentApi experimentApi;
	@Getter
	private ExperimentApiAsync experimentApiAsync;
	/*
	 * Filter Api
	 */
	@Getter
	private FilterApi filterApi;
	@Getter
	private FilterApiAsync filterApiAsync;

	/*
	 * Health Api
	 */
	@Getter
	private HealthApi healthApi;
	@Getter
	private HealthApiAsync healthApiAsync;
	/*
	 * MarkerSet Api
	 */
	@Getter
	private MarkerSetApi markerSetApi;
	@Getter
	private MarkerSetApiAsync markerSetApiAsync;

	/*
	 * OutputDescriptor Api
	 */
	@Getter
	private OutputDescriptorApi outputDescriptorApi;
	@Getter
	private OutputDescriptorApiAsync outputDescriptorApiAsync;

	/*
	 * Style Api
	 */
	@Getter
	private StyleApi styleApi;
	@Getter
	private StyleApiAsync styleApiAsync;

	/*
	 * Table Api
	 */
	@Getter
	private TableApi tableApi;
	@Getter
	private TableApiAsync tableApiAsync;
	/*
	 * TimeGraph Api
	 */
	@Getter
	private TimeGraphApi timeGraphApi;
	@Getter
	private TimeGraphApiAsync timeGraphApiAsync;
	/*
	 * Trace Api
	 */
	@Getter
	private TraceApi traceApi;
	@Getter
	private TraceApiAsync traceApiAsync;
	/*
	 * Xy Api
	 */
	@Getter
	private XyApi xyApi;
	@Getter
	private XyApiAsync xyApiAsync;

	public TspClient(String baseUrl) {
		this.constructAllApi(baseUrl, Executors.newSingleThreadExecutor());
	}

	public TspClient(String baseUrl, ExecutorService executorService) {
		this.constructAllApi(baseUrl, executorService);
	}

	private void constructAllApi(String baseUrl, ExecutorService executorService) {
		// Annotation Api
		this.annotationApi = new AnnotationApi(baseUrl);
		this.annotationApiAsync = new AnnotationApiAsync(baseUrl, executorService);
		// Bookmark Api
		this.bookmarkApi = new BookmarkApi(baseUrl);
		this.bookmarkApiAsync = new BookmarkApiAsync(baseUrl, executorService);
		// Experiment Api
		this.experimentApi = new ExperimentApi(baseUrl);
		this.experimentApiAsync = new ExperimentApiAsync(baseUrl, executorService);
		// Filter Api
		this.filterApi = new FilterApi(baseUrl);
		this.filterApiAsync = new FilterApiAsync(baseUrl, executorService);
		// Health Api
		this.healthApi = new HealthApi(baseUrl);
		this.healthApiAsync = new HealthApiAsync(baseUrl, executorService);
		// MarkerSet Api
		this.markerSetApi = new MarkerSetApi(baseUrl);
		this.markerSetApiAsync = new MarkerSetApiAsync(baseUrl, executorService);
		// OutputDescriptor Api
		this.outputDescriptorApi = new OutputDescriptorApi(baseUrl);
		this.outputDescriptorApiAsync = new OutputDescriptorApiAsync(baseUrl, executorService);
		// Style Api
		this.styleApi = new StyleApi(baseUrl);
		this.styleApiAsync = new StyleApiAsync(baseUrl, executorService);
		// Table Api
		this.tableApi = new TableApi(baseUrl);
		this.tableApiAsync = new TableApiAsync(baseUrl, executorService);
		// TimeGraph Api
		this.timeGraphApi = new TimeGraphApi(baseUrl);
		this.timeGraphApiAsync = new TimeGraphApiAsync(baseUrl, executorService);
		// Trace Api
		this.traceApi = new TraceApi(baseUrl);
		this.traceApiAsync = new TraceApiAsync(baseUrl, executorService);
		// Xy Api
		this.xyApi = new XyApi(baseUrl);
		this.xyApiAsync = new XyApiAsync(baseUrl, executorService);
	}
}
