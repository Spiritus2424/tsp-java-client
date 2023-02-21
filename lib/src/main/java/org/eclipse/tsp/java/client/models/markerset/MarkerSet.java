package org.eclipse.tsp.java.client.models.markerset;

public class MarkerSet {
    private String name;
    private String id;

    public MarkerSet() {
    }

    public MarkerSet(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (this == object)
            isEquals = true;
        else if (object == null || getClass() != object.getClass())
            isEquals = false;
        else {
            MarkerSet markerSet = (MarkerSet) object;
            isEquals = this.id.equals(markerSet.id);
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

}
