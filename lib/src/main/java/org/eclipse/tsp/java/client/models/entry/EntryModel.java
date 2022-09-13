package org.eclipse.tsp.java.client.models.entry;

public class EntryModel<T> {
    private EntryHeader[] headers;
    private T[] entries;

    public EntryModel() {
    }

    public EntryModel(EntryHeader[] headers, T[] entries) {
        this.headers = headers;
        this.entries = entries;
    }

    public EntryHeader[] getHeaders() {
        return headers;
    }

    public void setHeaders(EntryHeader[] headers) {
        this.headers = headers;
    }

    public T[] getEntries() {
        return entries;
    }

    public void setEntries(T[] entries) {
        this.entries = entries;
    }
}
