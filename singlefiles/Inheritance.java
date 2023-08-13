package singlefiles;
public class Inheritance {
    public static void main(String[] args) {
        for(int i=0; i<100/5 + 1; i++){
            DeviceWithBattery.showBatteryCharge();
            DeviceWithBattery.discharge();
        }
    }
}
class DeviceWithBattery{
    static int batteryCharge = 100;

    final static void charge(){
        if(batteryCharge >= 100){
            return;
        }
        batteryCharge += 5;
    }
    final static void discharge(){
        if(batteryCharge <= 0){
            return;
        }
        batteryCharge -= 5;
    }
    final static void showBatteryCharge(){
        String sqaureCharges;
        if (batteryCharge == 0) {
            sqaureCharges = "▢ ▢ ▢ ▢ ▢";
        } else if (batteryCharge <= 25) {
            sqaureCharges = "▣ ▢ ▢ ▢ ▢";
        } else if (batteryCharge < 50) {
            sqaureCharges = "▣ ▣ ▢ ▢ ▢";
        } else if (batteryCharge < 75) {
            sqaureCharges = "▣ ▣ ▣ ▢ ▢";
        } else if (batteryCharge < 90) {
            sqaureCharges = "▣ ▣ ▣ ▣ ▢";
        } else {
            sqaureCharges = "▣ ▣ ▣ ▣ ▣";
        }

        System.out.printf("Battery: %s (%d%%)\n", sqaureCharges, batteryCharge);
    }
}
