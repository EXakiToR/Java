package singlefiles.xmlproductsparse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlProductParse {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File file = new File("products.xml");

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

        List<ProductFromXml> products = new ArrayList<>();

        Element root = document.getDocumentElement();
        NodeList xmlProducts = root.getElementsByTagName("product");

        for (int i = 0; i < xmlProducts.getLength(); i++) {
            Element product = (Element) xmlProducts.item(i);
            
            products.add(new ProductFromXml(getTextFromElement(product, "name"),
                    new Money(Integer.parseInt(getTextFromElement(product, "amount")),
                            getTextFromElement(product, "currency"))));
        }
        System.out.println(products);
    }

    public static String getTextFromElement(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent().trim();
    }

    public static String getTextFromElement(Element element, String tagName, int index) {
        return element.getElementsByTagName(tagName).item(index).getTextContent().trim();
    }
}

class Money {
    private int amount;
    private String currency;

    public Money(int amount, String currency) {
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
        return "Money [amount=" + amount + ", currency=" + currency + "]";
    }

}

class ProductFromXml {
    private String name;
    private Money price;

    public ProductFromXml(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [productName=" + name + ", productPrice=" + price + "]\n";
    }
}
