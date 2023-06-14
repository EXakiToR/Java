package eshop;

import java.util.Arrays;

public class Product {
    private String name;
    private Integer price;
    private Attribute[] attributes;

    private Product() {
    };

    public static class ProductBuilder {
        private String name;
        private Integer price;

        private PhysicalDimension length, width, height, weight;

        ProductBuilder(String name, Integer price) {
            this.name = name;
            this.price = price;

        }

        public ProductBuilder withDimensions(PhysicalDimension lenght, PhysicalDimension width, PhysicalDimension height) {
            this.length = lenght;
            this.width = width;
            this.height = height;

            return this;
        }

        public ProductBuilder withWeight(PhysicalDimension weight) {
            this.weight = weight;

            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);

            product.setAttributes(new Attribute[4]);
            if (length != null) {
                product.getAttributes()[0] = new Attribute("lenght", length);
            }
            if (width != null) {
                product.getAttributes()[1] = new Attribute("width", width);
            }
            if (height != null) {
                product.getAttributes()[2] = new Attribute("height", height);
            }
            if (weight != null) {
                product.getAttributes()[3] = new Attribute("weight", weight);
            }
            return product;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", attributes=" + Arrays.toString(attributes) + "]";
    }

}
