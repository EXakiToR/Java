package eshop.util;

public class NamingConventionTransformer {
    public static String pascalFromSnake(String name) {
        String[] parts = name.split("_");
        String newName = "";
        for (String part : parts) {
            newName += part.substring(0, 1).toUpperCase() + part.substring(1);
        }
        return newName;
    }

    public static String snakeFromPascal(String name) {
        String newName = "";
        for (char c : name.toCharArray()) {
            if (Character.isUpperCase(c)) {
                newName += "_" + Character.toLowerCase(c);
            } else {
                newName += c;
            }
        }
        return newName.substring(1);
    }
}