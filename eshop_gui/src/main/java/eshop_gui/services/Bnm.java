package eshop_gui.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import eshop_gui.domain.Currency;

public class Bnm implements CurrencyService {
    private final String link = "https://www.bnm.md/ro/official_exchange_rates";
    private final List<String> selectedCurrencies = new ArrayList<>(Arrays.asList("USD", "EUR"));
    private Map<String, Currency> currencies = new HashMap<>();
    private String activeCurrency = "EUR";
    private String lastAccessed = null;
    private static Bnm instance;

    private Bnm() {

    }

    public static Bnm getInstance() {
        if (instance == null)
            instance = new Bnm();
        return instance;
    }

    public Map<String, Currency> getData() {

        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                linkWithParams = link + "?get_xml=1&date=" + currentDate;
        if (!currentDate.equals(lastAccessed)) {
            try (InputStream is = ((HttpURLConnection) new URL(linkWithParams).openConnection()).getInputStream()) {
                Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
                NodeList valutes = document.getElementsByTagName("Valute");
                for (int i = 0; i < valutes.getLength(); i++) {
                    Element valute = (Element) valutes.item(i);

                    int numCode = Integer.parseInt(getTextFromElement(valute, "NumCode"));
                    String charCode = getTextFromElement(valute, "CharCode"),
                            name = getTextFromElement(valute, "Name");
                    float ratio = Float.parseFloat(getTextFromElement(valute, "Value"));

                    if (selectedCurrencies.contains(charCode)) {
                        currencies.put(charCode, new Currency(name, charCode, numCode, ratio));
                    }

                }
            } catch (NumberFormatException | IOException | SAXException | ParserConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        lastAccessed = currentDate;
        return currencies;

    }

    private String getTextFromElement(Element e, String tagName) {
        return e.getElementsByTagName(tagName).item(0).getTextContent().trim();
    }

    public String getActiveCurrency() {
        return activeCurrency;
    }

    public void setActiveCurrency(String activeCurrency) {
        this.activeCurrency = activeCurrency;
    }

    public List<String> getSelectedcurrencies() {
        return selectedCurrencies;
    }

    @Override
    public String toString() {
        currencies.forEach((key, value) -> System.out.println(key + " " + value));
        return "";
    }
}
