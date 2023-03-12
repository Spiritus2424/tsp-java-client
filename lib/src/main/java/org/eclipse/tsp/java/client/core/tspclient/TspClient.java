package org.eclipse.tsp.java.client.core.tspclient;

import org.eclipse.tsp.java.client.api.annotation.AnnotationApi;
import org.eclipse.tsp.java.client.api.bookmark.BookmarkApi;
import org.eclipse.tsp.java.client.api.experiment.ExperimentApi;
import org.eclipse.tsp.java.client.api.filter.FilterApi;
import org.eclipse.tsp.java.client.api.health.HealthApi;
import org.eclipse.tsp.java.client.api.markerset.MarkerSetApi;
import org.eclipse.tsp.java.client.api.outputdescriptor.OutputDescriptorApi;
import org.eclipse.tsp.java.client.api.style.StyleApi;
import org.eclipse.tsp.java.client.api.table.TableApi;
import org.eclipse.tsp.java.client.api.timegraph.TimeGraphApi;
import org.eclipse.tsp.java.client.api.trace.TraceApi;
import org.eclipse.tsp.java.client.api.xy.XyApi;

import lombok.Getter;

public class TspClient {
    @Getter
    private AnnotationApi annotationApi;
    @Getter
    private BookmarkApi bookmarkApi;
    @Getter
    private ExperimentApi experimentApi;
    @Getter
    private FilterApi filterApi;
    @Getter
    private HealthApi healthApi;
    @Getter
    private MarkerSetApi markerSetApi;
    @Getter
    private OutputDescriptorApi outputDescriptorApi;
    @Getter
    private StyleApi styleApi;
    @Getter
    private TableApi tableApi;
    @Getter
    private TimeGraphApi timeGraphApi;
    @Getter
    private TraceApi traceApi;
    @Getter
    private XyApi xyApi;

    public TspClient(String baseUrl) {
        this.annotationApi = new AnnotationApi(baseUrl);
        this.bookmarkApi = new BookmarkApi(baseUrl);
        this.experimentApi = new ExperimentApi(baseUrl);
        this.filterApi = new FilterApi(baseUrl);
        this.healthApi = new HealthApi(baseUrl);
        this.markerSetApi = new MarkerSetApi(baseUrl);
        this.outputDescriptorApi = new OutputDescriptorApi(baseUrl);
        this.styleApi = new StyleApi(baseUrl);
        this.tableApi = new TableApi(baseUrl);
        this.timeGraphApi = new TimeGraphApi(baseUrl);
        this.traceApi = new TraceApi(baseUrl);
        this.xyApi = new XyApi(baseUrl);
    }
}
