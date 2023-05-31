package maincup;

import kitchen.Cup;
import world.Liquid;

public class Main {
    public static void main(String[] args) {
        
        Liquid white = new Liquid("milk", 950, (byte)19);
        Liquid transparent = new Liquid("water", 500, (byte)50);
        Liquid red = new Liquid("coca-cola", 2000, (byte)14);

        System.out.printf("%s %s %s\n",white.isCold(), white.isWarm(), white.isHot());
        System.out.printf("%s %s %s\n",transparent.isCold(), transparent.isWarm(), transparent.isHot());
        System.out.printf("%s %s %s\n",red.isCold(), red.isWarm(), red.isHot());

        Cup standartCup = new Cup(transparent);
        System.out.println(standartCup);
        transparent.setVolume(transparent.getVolume() + 50);
        standartCup.setVolume(transparent);
        System.out.println(standartCup);
    }
}
