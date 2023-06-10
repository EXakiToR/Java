package eshop;

public class Printer extends Product implements ProductInterface {
    private String format;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Printer [name=" + getName() + ", price=" + getPrice() + ", format=" + format + "]";
    }

}
