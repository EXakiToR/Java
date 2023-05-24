package kitchen;

public class SmallCup extends Cup{
    public SmallCup(String nameLiquid, short volumeLiquid) {
        super(nameLiquid, volumeLiquid);
    }
    @Override
    public void setVolumeLiquid(short volumeLiquid) {
        if (volumeLiquid > 0 && volumeLiquid <= 250){
            super.setVolumeLiquid(volumeLiquid);
        } else {
            System.err.println("Small cup volume must be between 0..250");
        }
        
    }
}
