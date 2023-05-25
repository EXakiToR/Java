package kitchen;

public class SmallCup extends Cup{

    public SmallCup(String nameLiquid, short cupVolume) {
        super(nameLiquid, cupVolume);

    }
    
    @Override
    public void setVolume(short cupVolume) {
        if (cupVolume > 0 && cupVolume <= super.getMaxVolume()){
            super.setVolume(cupVolume);
        } else {
            System.err.println(this.getClass().getSimpleName()+" volume must be between 0.."+super.getMaxVolume());
        }
        
    }

}
