package ca.polymtl.dorsal.models.experiment;

import java.math.BigInteger;
import java.util.ArrayList;

import ca.polymtl.dorsal.models.trace.Trace;

public class Experiment {
    private String UUID;
    private String name;
    private BigInteger start;
    private BigInteger end;
    private int nbEvents;
    private String indexingStatus;
    private ArrayList<Trace> traces;
}
