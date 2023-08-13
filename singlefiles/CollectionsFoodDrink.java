package singlefiles;

import java.util.LinkedList;
import java.util.List;


public class CollectionsFoodDrink {
    public static void main(String[] args) {
        List<Product> products = new LinkedList<>();
        products.add(new Food("Fille Minion", 15, 300));
        products.add(new AlcDrink("Aperitif", 5, 100));
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }
}

abstract class Product {
    private String name;
    private Integer price;

    public Product() {

    }

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + "]";
    }

}

class Food extends Product {
    private Integer weight;

    public Food(String name, Integer price, Integer weight) {
        super(name, price);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + ", weight=" + weight + "]";
    }

}

class AlcDrink extends Product {
    private Integer volume;

    public AlcDrink(String name, Integer price, Integer volume) {
        super(name, price);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() + ", weight=" + volume + "]";
    }
}