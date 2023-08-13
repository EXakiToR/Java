package appliancesD;

public class App {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        Boiler boiler = new Boiler((byte) 50);
        Blender blender = new Blender(9000);
        WashingMachine washingMachine = new WashingMachine(800, (byte) 40);
    }
}
