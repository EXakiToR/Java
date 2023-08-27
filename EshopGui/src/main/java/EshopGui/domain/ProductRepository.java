package EshopGui.domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import EshopGui.services.Bnm;

public class ProductRepository {
    private final String pathToProductsXml = "src/main/resources/products.xml";
    private Bnm bnm;

    public Product getTestProduct() {
        return new Product("Test product name",
                "Desc", "/images/testProduct.jpg",
                new Money(10.50f,
                        new Currency("US Dollar", "USD", 0, 0.9f)));
    }

    public List<Product> all() {
        try {
            return parseXml(pathToProductsXml);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private List<Product> parseXml(String path)
            throws SAXException, IOException, ParserConfigurationException {
        NodeList productsXml = getDocumentRootElement(path).getElementsByTagName("product");
        List<Product> products = new ArrayList<>();
        bnm = Bnm.getInstance();
        for (int i = 0; i < productsXml.getLength(); i++) {
            Element productXml = (Element) productsXml.item(i);
            products.add(new Product(getTextFromElement(productXml, "name"),
                    getTextFromElement(productXml, "description"),
                    "/images/testProduct.jpg",
                    new Money(Float.parseFloat(getTextFromElement(productXml, "amount")),
                            new Currency(getTextFromElement(productXml, "currency"),
                                    bnm.getData().get(getTextFromElement(productXml, "currency")).getRatio()))));
        }
        return products;
    }

    private Element getDocumentRootElement(String path)
            throws SAXException, IOException, ParserConfigurationException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(path));
        return document.getDocumentElement();
    }

    private String getTextFromElement(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent().trim();
    }

    private void setTextToElement(Element element, String tagName, String text) {
        element.getElementsByTagName(tagName).item(0).setTextContent(text);
    }

}
