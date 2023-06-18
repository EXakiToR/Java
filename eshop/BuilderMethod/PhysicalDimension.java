package eshop.BuilderMethod;

public class PhysicalDimension {
    private String unit;
    private Object value;

    public PhysicalDimension(Object value, String unit) {
        setUnit(unit);
        setValue(value);
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return getValue() + " " + getUnit();
    }

}
