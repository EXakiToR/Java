package singlefiles;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlProductParse {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File file = new File("products.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(file);

        List<ProductFromXml> products = new ArrayList<>();

        Element root = document.getDocumentElement();
        NodeList nodeProducts = root.getElementsByTagName("product");
        Element firstProduct = (Element) nodeProducts.item(0);
        NodeList nodeFirstProductPrice = firstProduct.getElementsByTagName("price");
        Element firstProductPrice = (Element) nodeFirstProductPrice.item(0);

        products.add(new ProductFromXml(getTextFromItem(firstProduct, "name", 0),
                new Price(Integer.parseInt(getTextFromItem(firstProductPrice, "amount", 0)),
                        getTextFromItem(firstProductPrice, "currency", 0))));
        System.out.println(products);
    }

    public static String getTextFromItem(Element element, String tagName, int index) {
        return element.getElementsByTagName(tagName).item(index).getTextContent().trim();
    }
}

class Price {
    private int amount;
    private String currency;

    public Price(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Price [amount=" + amount + ", currency=" + currency + "]";
    }

}

class ProductFromXml {
    private String name;
    private Price price;

    public ProductFromXml(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [productName=" + name + ", productPrice=" + price + "]";
    }
}
