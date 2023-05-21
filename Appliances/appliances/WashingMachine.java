package appliances;

public class WashingMachine extends Appliance implements CanSpin, CanHeatWater{
    private int rpm;
    private byte temperature;

    
    public WashingMachine() {
        super();

    }

    public WashingMachine(int rpm, byte temperature) {
        super(rpm * 3 / 2);
        spin(rpm);
        heat(temperature);
    }

    public int getRpm() {
        return rpm;
    }

    public byte getTemperature() {
        return temperature;
    }

    //Implementation
    public void spin(){
        rpm = 1000;
    }
    public void spin(int rpm){
        this.rpm = rpm;
    }
    public void heat() {
        temperature = 50;
    }
    public void heat(byte temperature) {
        this.temperature = temperature;
    }

}
