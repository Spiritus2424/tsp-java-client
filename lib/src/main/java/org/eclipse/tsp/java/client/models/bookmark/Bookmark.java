package org.eclipse.tsp.java.client.models.bookmark;

import java.math.BigInteger;

public class Bookmark {
    private String uuid;
    private String name;
    private BigInteger startTime;
    private BigInteger endTime;
    private String type;

    public Bookmark(String uuid, String name, BigInteger startTime, BigInteger endTime, String type) {
        this.uuid = uuid;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    public String getuuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
