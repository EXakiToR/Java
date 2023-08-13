package appliancesD;

abstract public class Appliance {
    private int powerConsump;

    public Appliance() {
        powerConsump = 1;
    }

    public Appliance(int powerConsump) {
        setPowerConsump(powerConsump);
    }

    public int getPowerConsump() {
        return powerConsump;
    }

    public void setPowerConsump(int powerConsump) {
        if (powerConsump > 0 && powerConsump < 10_000) {
            this.powerConsump = powerConsump;
        } else {
            System.err.println("Power consumprion should lie between 0..10000 watts");
        }

    }
}
