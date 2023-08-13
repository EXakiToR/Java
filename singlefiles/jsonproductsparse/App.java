import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App {
    public static void main(String[] args) throws IOException {
        File file = new File("products.json");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String data = "", line = null;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                data += line;
            }
        JsonElement document = JsonParser.parseString(data);
        JsonArray productsJson = document.getAsJsonArray();
        JsonObject product = productsJson.get(0).getAsJsonObject();
        String name = product.get("name").getAsString();
        JsonObject price = product.get("price").getAsJsonObject();

        int amount = price.get("amount").getAsInt();
        String currency = price.get("currency").getAsString();
        
        System.out.println(name);
        System.out.println(amount);
        System.out.println(currency);
    }
}
