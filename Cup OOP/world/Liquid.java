package world;

public class Liquid {
    private String name;
    private int volume;
    private byte temperature;

    public Liquid() {
    }

    public Liquid(String name, int volume, byte temperature) {
        setName(name);
        setVolume(volume);
        setTemperature(temperature);
    }

    public boolean isCold(){
        if(temperature <= 18){
            return true;
        } else {
            return false;
        }
    }
    public boolean isWarm(){
        if(temperature > 18 && temperature <= 36){
            return true;
        } else {
            return false;
        }
    }
    public boolean isHot(){
        if(temperature > 36){
            return true;
        } else {
            return false;
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!name.equals(null)){
            this.name = name;
        } else {
            System.err.println("Name can't be empty");
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if(volume > 0){
            this.volume = volume;
        } else {
            System.err.println("Volume must be > 0");
        }
    }

    public byte getTemperature() {
        return temperature;
    }

    public void setTemperature(byte temperature) {
        if(temperature > 0 && temperature < 100){
            this.temperature = temperature;
        } else {
            System.err.println("Temperature must be between 0..100");
        }
    }
    
    
}
