package kitchen;

public class Cup {
    private String nameLiquid;
    private short cupVolume;

    public Cup() {
    }

    public Cup(String nameLiquid, short cupVolume) {
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
        return 600;
    }

    public short getVolume() {
        return cupVolume;
    }
    public void setVolume(short cupVolume) {
        
        //part 1
        if (cupVolume > 0 && cupVolume <= getMaxVolume()){
            this.cupVolume = cupVolume;
        } else {
            System.err.println(this.getClass().getSimpleName()+" volume must be between 0.."+getMaxVolume());
        }
        
    }
    
    public String toString(){
        return ""+cupVolume+"ml of "+nameLiquid;
    }
}
