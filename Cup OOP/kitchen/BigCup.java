package kitchen;

public class BigCup extends Cup {
    public BigCup(String nameLiquid, short volumeLiquid) {
        super(nameLiquid, volumeLiquid);
    }
    @Override
    public void setVolumeLiquid(short volumeLiquid) {
        if (volumeLiquid > 0 && volumeLiquid <= 1000){
            super.setVolumeLiquid(volumeLiquid);
        } else {
            System.err.println("Big cup volume must be between 0..1000");
        }
        
    }
}
