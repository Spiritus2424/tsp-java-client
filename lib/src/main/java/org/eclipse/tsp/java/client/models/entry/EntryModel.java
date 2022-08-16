package org.eclipse.tsp.java.client.models.entry;

import java.util.ArrayList;

public class EntryModel<T> {
    private ArrayList<EntryHeader> headers;
    private ArrayList<T> entries;

    public EntryModel(ArrayList<EntryHeader> headers, ArrayList<T> entries) {
        this.headers = headers;
        this.entries = entries;
    }

    public ArrayList<EntryHeader> getHeaders() {
        return headers;
    }

    public void setHeaders(ArrayList<EntryHeader> headers) {
        this.headers = headers;
    }

    public ArrayList<T> getEntries() {
        return entries;
    }

    public void setEntries(ArrayList<T> entries) {
        this.entries = entries;
    }
}
