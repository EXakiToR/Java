package kitchen;

public class SmallCup extends Cup{
    private short cupVolume;

    public SmallCup(String nameLiquid, short cupVolume) {
        super(nameLiquid);
        setVolume(cupVolume);
    }
    @Override
    public void setVolume(short cupVolume) {
        if (cupVolume > 0 && cupVolume <= 250){
            this.cupVolume = cupVolume;
        } else {
            System.err.println("Small cup volume must be between 0..250");
        }
        
    }
    @Override
    public short getVolume() {
        return cupVolume;
    }
    @Override
    public String toString(){
        return ""+cupVolume+"ml of "+getNameLiquid();
    }
}
