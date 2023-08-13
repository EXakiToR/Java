package blenderworksimulation;

public class Juice {
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if(volume > 0){
            this.volume = volume;
        }

    }

    public Juice(int volume) {
        setVolume(volume);
    }
    
}
