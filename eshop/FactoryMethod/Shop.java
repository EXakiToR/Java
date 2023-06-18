package eshop.FactoryMethod;

public class Shop {
    public static void main(String[] args) {
        eshop.FactoryMethod.Product phone = ProductFactory.createProduct("phone", "Redmi note 9 pro", 4000, 6.67f);
        eshop.FactoryMethod.Product laptop = ProductFactory.createProduct("Laptop", "Samsung Notebook 9 Pro", 22000, "Intel Core i7-8550U");
        eshop.FactoryMethod.Product printer = ProductFactory.createProduct("PRINTER", "CANON PIXMA G540", 6000, "A4");
        System.out.printf("%s\n%s\n%s\n", phone, laptop, printer);
    }
}
