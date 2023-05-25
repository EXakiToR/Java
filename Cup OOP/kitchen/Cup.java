package kitchen;

public class Cup {
    private String nameLiquid;
    private short cupVolume, maxVolume;

    public Cup() {
    }

    public Cup(String nameLiquid, short cupVolume) {
        setMaxVolume();
        setNameLiquid(nameLiquid);
        setVolume(cupVolume);
        
    }

    public String getNameLiquid() {
        return nameLiquid;
    }

    public void setNameLiquid(String nameLiquid) {
        if(nameLiquid.equalsIgnoreCase("water") || nameLiquid.equalsIgnoreCase("milk") ||
        nameLiquid.equalsIgnoreCase("tea")){
            this.nameLiquid = nameLiquid.toLowerCase();
        } else {
            System.err.println("Unsuported liquid type.");
        }
        
    }

    public short getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume() {
        if (this instanceof SmallCup) {
            this.maxVolume = 250;
        } else if (this instanceof BigCup) {
            this.maxVolume = 1000;
        } else {
            this.maxVolume = 600;
        }
    }

    public short getVolume() {
        return cupVolume;
    }
    public void setVolume(short cupVolume) {
        
        //part 1
        if (cupVolume > 0 && cupVolume <= maxVolume){
            this.cupVolume = cupVolume;
        } else {
            System.err.println(this.getClass().getSimpleName()+" volume must be between 0.."+maxVolume);
        }
        
    }
    
    public String toString(){
        return ""+cupVolume+"ml of "+nameLiquid;
    }
}
