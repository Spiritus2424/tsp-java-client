package ca.polymtl.dorsal.models.xy;

public class XYAxis {
    private String label;
    private String unit;
    private String dataType;

    public XYAxis(String label, String unit, String dataType) {
        this.label = label;
        this.unit = unit;
        this.dataType = dataType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

}
