package eshop.factorypattern;

//Must add more products defined in code, it becomes too big
public class ProductFactory {
    private static Product createBaseProduct(String type, String name, int price) {
        Product product = null;
        String formattedType = type.toLowerCase();
        switch (formattedType) {
            case "phone":
                product = new Phone();
                break;
            case "printer":
                product = new Printer();
                break;
            case "laptop":
                product = new Laptop();
                break;

            default:
                System.err.println("No such category yet!");
                break;
        }

        if (product != null) {
            product.setName(name);
            product.setPrice(price);
        }
        return product;
    }

    public static Product createProduct(String type, String name, int price, float diagonal) {
        Product product = createBaseProduct(type, name, price);
        ((Phone) product).setDiagonal(diagonal);
        return product;
    }

    public static Product createProduct(String type, String name, int price, String stringValue) {
        Product product = createBaseProduct(type, name, price);
        String formattedType = type.toLowerCase();
        switch (formattedType) {
            case "printer":
                ((Printer) product).setFormat(stringValue);

                break;
            case "laptop":
                ((Laptop) product).setCPU(stringValue);

                break;

            default:
                System.err.println("No such category yet!");
                break;
        }
        return product;
    }

}
