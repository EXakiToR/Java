package kitchen;

public class BigCup extends Cup{

    public BigCup(String nameLiquid, short cupVolume) {
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
