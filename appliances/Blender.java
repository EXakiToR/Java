package appliancesD;

public class Blender extends Appliance implements CanSpin {
    private int rpm;

    public Blender() {
        super();

    }

    public Blender(int rpm) {
        super(rpm * 3 / 100);
        spin(rpm);
    }

    public Blender(int powerConsump, int rpm) {
        super(powerConsump);
        spin(rpm);
    }

    public int getRpm() {
        return rpm;
    }

    // Implementation
    public void spin() {
        rpm = 10000;
    }

    public void spin(int rpm) {
        this.rpm = rpm;
    }

}
