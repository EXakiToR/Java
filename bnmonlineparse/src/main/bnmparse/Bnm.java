package com.bnmparse;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Bnm {
    private static final String link = "https://www.bnm.md/ro/official_exchange_rates";
    private static final List<String> selectedCurrencies = new ArrayList<>(Arrays.asList("USD", "EUR"));
    private static List<Currency> currencies = new ArrayList<>();

    public static List<Currency> getData() throws IOException, SAXException, ParserConfigurationException {
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                linkWithParams = link + "?get_xml=1&date=" + currentDate;

        InputStream is = ((HttpURLConnection) new URL(linkWithParams).openConnection()).getInputStream();
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
        NodeList valutes = document.getElementsByTagName("Valute");
        for (int i = 0; i < valutes.getLength(); i++) {
            Element valute = (Element) valutes.item(i);

            int numCode = Integer.parseInt(getTextFromElement(valute, "NumCode"));
            String charCode = getTextFromElement(valute, "CharCode"),
                    name = getTextFromElement(valute, "Name");
            float ratio = Float.parseFloat(getTextFromElement(valute, "Value"));

            if (selectedCurrencies.contains(charCode)) {
                currencies.add(new Currency(name, charCode, numCode, ratio));
            }
            
        }
        return currencies;

    }

    private static String getTextFromElement(Element e, String tagName) {
        return e.getElementsByTagName(tagName).item(0).getTextContent().trim();
    }

}
