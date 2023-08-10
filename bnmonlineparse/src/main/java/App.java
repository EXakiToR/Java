
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class App {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        Map<String, Currency> currencies = Bnm.getData();

        System.out.println(currencies);

    }
}
