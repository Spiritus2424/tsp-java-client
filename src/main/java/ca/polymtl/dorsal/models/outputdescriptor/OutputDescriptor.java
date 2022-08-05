import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;

public class OutputDescriptor {
    private String id;
    private String name;
    private String description;
    private String type;
    private Map<String, Object> queryParameters;
    private BigInteger start;
    private BigInteger end;
    private boolean isFinal;
    private ArrayList<String> compatibleProviders;
}
