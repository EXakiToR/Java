package kitchen;

public class BigCup extends Cup {
    private short cupVolume;
    public BigCup(String nameLiquid, short cupVolume) {
        super(nameLiquid);
        setVolume(cupVolume);
    }
    @Override
    public void setVolume(short cupVolume) {
        if (cupVolume > 0 && cupVolume <= 1000){
            this.cupVolume = cupVolume;
        } else {
            System.err.println("Big cup volume must be between 0..1000");
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
