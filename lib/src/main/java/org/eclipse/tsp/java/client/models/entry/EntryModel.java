package org.eclipse.tsp.java.client.models.entry;

import java.util.ArrayList;
import java.util.List;

public class EntryModel<T> {
    private List<EntryHeader> headers;
    private List<T> entries;

    public EntryModel() {
        headers = new ArrayList<>();
        entries = new ArrayList<>();
    }

    public EntryModel(List<EntryHeader> headers, List<T> entries) {
        this.headers = headers;
        this.entries = entries;
    }

    public List<EntryHeader> getHeaders() {
        return headers;
    }

    public void setHeaders(List<EntryHeader> headers) {
        this.headers = headers;
    }

    public List<T> getEntries() {
        return entries;
    }

    public void setEntries(List<T> entries) {
        this.entries = entries;
    }
}
