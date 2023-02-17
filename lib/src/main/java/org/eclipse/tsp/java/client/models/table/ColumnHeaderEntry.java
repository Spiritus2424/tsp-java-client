package org.eclipse.tsp.java.client.models.table;

public class ColumnHeaderEntry {
    private int id;
    private String name;
    private String description;
    private String type;

    public ColumnHeaderEntry() {
    }

    public ColumnHeaderEntry(int id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (this == object)
            isEquals = true;
        else if (object == null || getClass() != object.getClass())
            isEquals = false;
        else {
            ColumnHeaderEntry columnHeaderEntry = (ColumnHeaderEntry) object;
            isEquals = this.id == columnHeaderEntry.getId();
        }

        return isEquals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
