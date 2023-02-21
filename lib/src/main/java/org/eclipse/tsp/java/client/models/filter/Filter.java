package org.eclipse.tsp.java.client.models.filter;

import java.math.BigInteger;

public class Filter {
    private String id;
    private String name;
    private BigInteger startTime;
    private BigInteger endTime;
    private String expression;
    private int tags;

    public Filter() {
    }

    public Filter(String id, String name, BigInteger startTime, BigInteger endTime, String expression, int tags) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.expression = expression;
        this.tags = tags;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (this == object)
            isEquals = true;
        else if (object == null || getClass() != object.getClass())
            isEquals = false;
        else {
            Filter filter = (Filter) object;
            isEquals = this.id.equals(filter.getId());
        }

        return isEquals;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public int getTags() {
        return tags;
    }

    public void setTags(int tags) {
        this.tags = tags;
    }

}
