package kitchen;

public class Cup {
    private String nameLiquid;
    private short volumeLiquid;
    
    public Cup() {
    }

    public Cup(String nameLiquid, short volumeLiquid) {
        setNameLiquid(nameLiquid);
        setVolumeLiquid(volumeLiquid);
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

    public short getVolumeLiquid() {
        return volumeLiquid;
    }
    public void setVolumeLiquid(short volumeLiquid) {
        this.volumeLiquid = volumeLiquid;
        //part 1
        // if (volumeLiquid > 0 && volumeLiquid <= 600){
            
        // } else {
        //     System.err.println("Volume must be between 0..600");
        // }
        
    }
    public String toString(){
        return ""+volumeLiquid+"ml of "+getNameLiquid();
    }
}
