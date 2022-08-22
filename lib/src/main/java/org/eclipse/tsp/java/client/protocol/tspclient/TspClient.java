package org.eclipse.tsp.java.client.protocol.tspclient;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.swing.table.TableModel;

import org.eclipse.tsp.java.client.models.annotation.AnnotationCategoriesModel;
import org.eclipse.tsp.java.client.models.annotation.AnnotationModel;
import org.eclipse.tsp.java.client.models.entry.Entry;
import org.eclipse.tsp.java.client.models.entry.EntryModel;
import org.eclipse.tsp.java.client.models.experiment.Experiment;
import org.eclipse.tsp.java.client.models.health.HealthStatus;
import org.eclipse.tsp.java.client.models.markerset.MarkerSet;
import org.eclipse.tsp.java.client.models.outputdescriptor.OutputDescriptor;
import org.eclipse.tsp.java.client.models.query.Query;
import org.eclipse.tsp.java.client.models.response.GenericResponse;
import org.eclipse.tsp.java.client.models.style.OutputStyleModel;
import org.eclipse.tsp.java.client.models.table.ColumnHeaderEntry;
import org.eclipse.tsp.java.client.models.timegraph.TimeGraphArrow;
import org.eclipse.tsp.java.client.models.timegraph.TimeGraphEntry;
import org.eclipse.tsp.java.client.models.timegraph.TimeGraphModel;
import org.eclipse.tsp.java.client.models.trace.Trace;
import org.eclipse.tsp.java.client.models.xy.XYModel;
import org.eclipse.tsp.java.client.protocol.restclient.RestClient;
import org.eclipse.tsp.java.client.protocol.restclient.TspClientResponse;

public class TspClient {
    private String baseUrl;

    public TspClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public TspClientResponse<Trace[]> getTraces(Optional<Map<String, String>> queryParameters) {

        return RestClient.get(String.format("%s/traces", this.baseUrl), queryParameters);
    }

    public TspClientResponse<Trace> getTrace(String traceUuid) {
        return RestClient.get(String.format("%s/traces/%s", this.baseUrl, traceUuid), Optional.empty());
    }

    public TspClientResponse<Trace> openTrace(Query query) {
        return RestClient.post(String.format("%s/traces", this.baseUrl), Optional.of(query));
    }

    public TspClientResponse<Trace> deleteTrace(String traceUuid, Optional<Boolean> removeFromCache,
            Optional<Boolean> deleteFromDisk) {
        Map<String, String> queryParameters = new HashMap<String, String>();
        if (removeFromCache.isPresent()) {
            queryParameters.put("removeCache", removeFromCache.get().toString());
        }

        if (deleteFromDisk.isPresent()) {
            queryParameters.put("deleteTrace", deleteFromDisk.get().toString());
        }

        return RestClient.delete(String.format("%s/traces/%s", this.baseUrl, traceUuid), Optional.of(queryParameters));
    }

    public TspClientResponse<Experiment[]> getExperiments(Optional<Map<String, String>> queryParameters) {
        return RestClient.get(String.format("%s/experiments", this.baseUrl), queryParameters);
    }

    public TspClientResponse<Experiment> getExperiment(String experimentUuid) {
        return RestClient.get(String.format("%s/experiments/%s", this.baseUrl, experimentUuid), Optional.empty());
    }

    public TspClientResponse<Experiment> createExperiment(Query query) {
        return RestClient.post(String.format("%s/experiments", this.baseUrl), Optional.of(query));
    }

    public TspClientResponse<Experiment> updateExperiment(String experimentUuid, Query query) {
        return RestClient.put(String.format("%s/experiments", this.baseUrl), Optional.of(query));
    }

    public TspClientResponse<Experiment> deleteExperiment(String experimentUuid) {
        return RestClient.delete(String.format("%s/experiments/%s", this.baseUrl, experimentUuid), Optional.empty());
    }

    public TspClientResponse<OutputDescriptor[]> experimentOutPuts(String experimentUuid,
            Optional<Map<String, String>> queryParameters) {
        return RestClient.get(String.format("%s/experiments/%s/outputs", this.baseUrl, experimentUuid),
                queryParameters);
    }

    public TspClientResponse<GenericResponse<EntryModel<Entry>>> getXYTree(String experimentUuid, String outputId,
            Query query) {
        return RestClient.post(
                String.format("%s/experiments/%s/outputs/XY/%s/tree", this.baseUrl, experimentUuid, outputId),
                Optional.of(query));
    }

    public TspClientResponse<GenericResponse<EntryModel<XYModel>>> getXY(String experimentUuid, String outputId,
            Query query) {
        return RestClient.post(
                String.format("%s/experiments/%s/outputs/XY/%s/xy", this.baseUrl, experimentUuid, outputId),
                Optional.of(query));
    }

    public TspClientResponse<GenericResponse<EntryModel<XYModel>>> getXYToolTip(String experimentUuid, String outputId,
            int xValue, Optional<Integer> yValue, Optional<String> seriesId) {
        Map<String, String> queryParameters = new HashMap<String, String>();
        if (yValue.isPresent()) {
            queryParameters.put("yValue", yValue.get().toString());
        }

        if (seriesId.isPresent()) {
            queryParameters.put("seriesId", seriesId.get().toString());
        }

        return RestClient.get(
                String.format("%s/experiments/%s/outputs/XY/%s/tooltip", this.baseUrl, experimentUuid, outputId),
                Optional.of(queryParameters));
    }

    public TspClientResponse<GenericResponse<EntryModel<TimeGraphEntry>>> getTimeGraphTree(String experimentUuid,
            String outputId,
            Query query) {
        return RestClient.post(
                String.format("%s/experiments/%s/outputs/timeGraph/%s/tree", this.baseUrl, experimentUuid, outputId),
                Optional.of(query));
    }

    public TspClientResponse<GenericResponse<EntryModel<TimeGraphModel>>> getTimeGraphStates(String experimentUuid,
            String outputId,
            Query query) {
        return RestClient.post(
                String.format("%s/experiments/%s/outputs/timeGraph/%s/states", this.baseUrl, experimentUuid, outputId),
                Optional.of(query));
    }

    public TspClientResponse<GenericResponse<EntryModel<TimeGraphArrow[]>>> getTimeGraphArrows(String experimentUuid,
            String outputId,
            Query query) {
        return RestClient.post(
                String.format("%s/experiments/%s/outputs/timeGraph/%s/arrows", this.baseUrl, experimentUuid, outputId),
                Optional.of(query));
    }

    public TspClientResponse<GenericResponse<MarkerSet[]>> getMarkerSets(String experimentUuid) {
        return RestClient.get(
                String.format("%s/experiments/%s/outputs/markerSets", this.baseUrl, experimentUuid),
                Optional.empty());
    }

    public TspClientResponse<GenericResponse<AnnotationCategoriesModel>> getAnnotationsCategories(
            String experimentUuid, String outputId, Optional<String> markerSetId) {
        Map<String, String> queryParameters = null;
        if (markerSetId.isPresent()) {
            queryParameters = new HashMap<String, String>();
            queryParameters.put("markserId", markerSetId.get());
        }

        return RestClient.get(
                String.format("%s/experiments/%s/outputs/%s/annotations", this.baseUrl, experimentUuid, outputId),
                markerSetId.isPresent() ? Optional.of(queryParameters) : Optional.empty());
    }

    public TspClientResponse<GenericResponse<AnnotationModel>> getAnnotations(String experimentUuid, String outputId,
            Query query) {
        return RestClient.post(
                String.format("%s/experiments/%s/outputs/%s/annotations", this.baseUrl, experimentUuid, outputId),
                Optional.of(query));
    }

    public TspClientResponse<GenericResponse<Map<String, String>>> getTimeGraphTooltip(String experimentUuid,
            String outputId,
            Query query) {
        return RestClient.post(
                String.format("%s/experiments/%s/outputs/timeGraph/%s/tooltip", this.baseUrl, experimentUuid, outputId),
                Optional.of(query));
    }

    public TspClientResponse<GenericResponse<ColumnHeaderEntry[]>> getTableColumns(String experimentUuid,
            String outputId,
            Query query) {
        return RestClient.post(
                String.format("%s/experiments/%s/outputs/table/%s/columns", this.baseUrl, experimentUuid, outputId),
                Optional.of(query));
    }

    public TspClientResponse<GenericResponse<TableModel>> getTableLines(String experimentUuid,
            String outputId,
            Query query) {
        return RestClient.post(
                String.format("%s/experiments/%s/outputs/table/%s/lines", this.baseUrl, experimentUuid, outputId),
                Optional.of(query));
    }

    public TspClientResponse<GenericResponse<OutputStyleModel>> getStyles(String experimentUuid,
            String outputId,
            Query query) {
        return RestClient.post(
                String.format("%s/experiments/%s/outputs/%s/style", this.baseUrl, experimentUuid, outputId),
                Optional.of(query));
    }

    public TspClientResponse<HealthStatus> checkHealth() {
        return RestClient.get(String.format("%s/health", this.baseUrl), Optional.empty());
    }
}
