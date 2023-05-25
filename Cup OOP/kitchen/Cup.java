package kitchen;

public class Cup {
    private String nameLiquid;
    private short cupVolume;
    
    public Cup() {
    }
    
    public Cup(String nameLiquid) {
        setNameLiquid(nameLiquid);
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

    public short getVolume() {
        return cupVolume;
    }
    public void setVolume(short cupVolume) {
        
        //part 1
        if (cupVolume > 0 && cupVolume <= 600){
            this.cupVolume = cupVolume;
        } else {
            System.err.println("Volume must be between 0..600");
        }
        
    }
    
    public String toString(){
        return ""+cupVolume+"ml of "+getNameLiquid();
    }
}
