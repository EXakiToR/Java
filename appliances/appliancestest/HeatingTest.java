package appliances.appliancestest;

import appliances.Boiler;
import appliances.WashingMachine;
import appliances.CanHeatWater;
public class HeatingTest implements Test {

    public boolean test() {
        return heatTest(new Boiler((byte) 50)) && heatTest(new WashingMachine());
    }

    public boolean heatTest(CanHeatWater testable) {
        byte temperatureBefore = testable.getTemperature();
        testable.heat();
        byte temperatureAfter = testable.getTemperature();

        if (temperatureAfter > temperatureBefore) {
            System.out.println("Heating test: passed!");
            return true;
        } else {
            System.err.printf("Heating test: failed!\nTemp before test %d, temp after test %d\n",
                    temperatureBefore, temperatureAfter);
            return false;
        }
    }
}
