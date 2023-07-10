package eshop.builderpattern;

public class Shop {
    public static void main(String[] args) {
        Product product = new Product.ProductBuilder("Samsung S 23", 9000)
                .withDimensions(new PhysicalDimension(4.1, "inch"),
                        new PhysicalDimension(2, "inch"),
                        new PhysicalDimension(.1, "inch"))
                .withWeight(new PhysicalDimension(212.3, "g"))
                .build();
        System.out.println(product);

    }
}
