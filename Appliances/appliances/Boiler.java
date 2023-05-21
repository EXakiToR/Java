package appliances;

public class Boiler extends Appliance implements CanHeatWater{
    private byte temperature;

    public Boiler() {
        super();

    }

    public Boiler(byte temperature) {
        super(temperature * 75 / 2);
        heat(temperature);
    }

    public Boiler(int powerConsump, byte temperature) {
        super(powerConsump);
        heat(temperature);
    }

    public byte getTemperature() {
        return temperature;
    }

    //Implementation
    public void heat(){
        temperature = 70;
    }

    public void heat(byte temperature){
        this.temperature = temperature;
    }
    
    
}
