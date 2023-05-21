package mainappliances;

import appliances.Blender;
import appliances.Boiler;
import appliances.WashingMachine;

public class Main {
    public static void main(String[] args) {
        Boiler boiler = new Boiler((byte)50);
        Blender blender = new Blender(9000);
        WashingMachine washingMachine = new WashingMachine(800, (byte)40);
    }
}
