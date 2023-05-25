package maincup;

import kitchen.BigCup;
import kitchen.Cup;
import kitchen.SmallCup;

public class Main {
    public static void main(String[] args) {
        //part 1
        Cup cupA = new Cup("Milk", (short)300);
        Cup cupB = new Cup("Water", (short)500);
        
        System.out.println("CupA - "+cupA+", CupB - "+cupB );
        cupA.setVolume((short)(cupA.getVolume() - 50));
        cupB.setVolume((short)(cupB.getVolume() + 50));
        System.out.println("CupA - "+cupA+", CupB - "+cupB );

        //part 2 
        Cup smallCup = new SmallCup("Tea", (short)200);
        Cup bigCup = new BigCup("water", (short)2000);

        System.out.println("A small cup - "+smallCup);
        bigCup.setVolume((short)(cupB.getVolume() + bigCup.getVolume()));
        System.out.println("A big cup now contains "+bigCup);
        
    }
}
