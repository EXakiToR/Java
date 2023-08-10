

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, SAXException, ParserConfigurationException
    {
        List<Currency> currencies = Bnm.getData();

        for (Currency currency : currencies) {
            System.out.println(currency);
        }
        
    }
}
