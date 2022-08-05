package ca.polymtl.dorsal.models.entry;

import java.util.ArrayList;

public class EntryModel<T> {
    private ArrayList<EntryHeader> headers;
    private ArrayList<T> entries;
}
