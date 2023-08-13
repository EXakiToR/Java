package singlefiles.readcsvproduct;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsvProduct {
    public static void main(String[] args) throws IOException {
        File file = new File("products.csv");
        FileReader fw = new FileReader(file);
        BufferedReader br = new BufferedReader(fw);
        
        List<ProductFromFile> products = new ArrayList<>();
        while (true) {
            String fileLine = br.readLine();
            if (fileLine == null) break;
            String[] cols = fileLine.trim().split(",");
            products.add(new ProductFromFile(cols[0], Integer.parseInt(cols[1])));

        }
        for (ProductFromFile productFromFile : products) {
            System.out.println(productFromFile);
        }
        
    }
}

class ProductFromFile {
    private String name;
    private int price;

    public ProductFromFile(String productName, int productPrice) {
        this.name = productName;
        this.price = productPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int productPrice) {
        this.price = productPrice;
    }

    @Override
    public String toString() {
        return "Product [productName=" + name + ", productPrice=" + price + "]";
    }
}
