package appliances.appliancestest;

import appliances.Blender;
import appliances.WashingMachine;
import appliances.CanSpin;
public class SpinTest implements Test {

    public boolean test() {
        return spinTest(new Blender()) && spinTest(new WashingMachine());
    }
    public boolean spinTest(CanSpin testable) {
        int spinBefore = testable.getRpm();
        testable.spin();
        int spinAfter = testable.getRpm();

        if (spinAfter != spinBefore) {
            System.out.println("Spin test: passed!");
            return true;
        } else {
            System.err.printf("Spin test: failed!\n Spin before test %d, spin after test %d",
            spinBefore, spinAfter);
            return false;
        }
    }
    
}
