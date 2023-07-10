package eshop.builderpattern;

import java.util.Arrays;

//Builder pattern

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

        public ProductBuilder withDimensions(PhysicalDimension lenght, PhysicalDimension width,
                PhysicalDimension height) {
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

            if (length != null) {
                addAtribute(product, new Attribute("lenght", length));
            }
            if (width != null) {
                addAtribute(product, new Attribute("width", width));
            }
            if (height != null) {
                addAtribute(product, new Attribute("height", height));
            }
            if (weight != null) {
                addAtribute(product, new Attribute("weight", weight));
            }
            return product;
        }

        public void addAtribute(Product product, Attribute attribute) {
            if (product.getAttributes() == null) {
                product.setAttributes(new Attribute[1]);
            } else {
                product.setAttributes(Arrays.copyOf(product.getAttributes(), product.getAttributes().length + 1));
            }
            product.getAttributes()[product.getAttributes().length - 1] = attribute;
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
