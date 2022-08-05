import java.math.BigInteger;

public class Bookmark {
    private String UUID;
    private String name;
    private BigInteger startTime;
    private BigInteger endTime;
    private String type;

    public Bookmark(String uUID, String name, BigInteger startTime, BigInteger endTime, String type) {
        UUID = uUID;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String uUID) {
        UUID = uUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getStartTime() {
        return startTime;
    }

    public void setStartTime(BigInteger startTime) {
        this.startTime = startTime;
    }

    public BigInteger getEndTime() {
        return endTime;
    }

    public void setEndTime(BigInteger endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
