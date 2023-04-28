public class MakeCoffee {
    public static void main(String[] args) {
        Container cup = new Cup();
        Container coffeepot = new Coffeepot();
        CoffeeMachine publicCoffeeMachine = new CoffeeMachine();
        
        publicCoffeeMachine.workSimulation(cup);
        publicCoffeeMachine.workSimulation(coffeepot);
    }
}

abstract class Container{
    private int volume = 0;

    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        if(volume >= 0 && volume <= getMaxVolume()){
            this.volume = volume;
        } else {
            System.err.printf("Volume exceeds 0..%dml interval\n", getMaxVolume());
        }
    }
    boolean isFull(){
        return volume == getMaxVolume();
    }
    @Override
    public String toString(){
        String symbolCup = "";
        byte width = getWidth();
        String space = "";
        for(int row = 1; row <= 5; row++){
            switch (row){
                //Top part of cup
                case 1:
                    symbolCup += "+";
                    for(int i = 0; i < width; i++){
                        if(volume == getMaxVolume()){
                            symbolCup += "~";
                        } else symbolCup += "-";
                    }
                    symbolCup += "+\n";
                    break;
                //Middle part of cup
                case 2:
                    symbolCup += space + "\\";
                    for(int i = 0; i < width; i++){
                        if(volume >= getMaxVolume()*0.75 && volume < getMaxVolume()){
                            symbolCup += "~";
                        } else symbolCup += " ";
                    }
                    symbolCup += "/\n";
                    break;

                case 3:
                    symbolCup += space + "\\";
                    for(int i = 0; i < width; i++){
                        if(volume >= getMaxVolume()*0.5 && volume < getMaxVolume()*0.75){
                            symbolCup += "~";
                        } else symbolCup += " ";
                    }
                    symbolCup += "/\n";
                    break;

                case 4:
                    symbolCup += space + "\\";
                    for(int i = 0; i < width; i++){
                        if(volume >= getMaxVolume()*0.25 && volume < getMaxVolume()*0.5){
                            symbolCup += "~";
                        } else symbolCup += " ";
                    }
                    symbolCup += "/\n";
                    break;
                //Bottom part of cup
                case 5:
                    symbolCup += space + "+";
                    for(int i = 0; i < width; i++){
                        if(volume >= 0 && volume < getMaxVolume()*0.25){
                            symbolCup += "~";
                        } else symbolCup += "-";
                    }
                    symbolCup += "+";
                    break;
            }
            width -= 2;
            space += " ";
        };
        return symbolCup;
    }
    public abstract int getMaxVolume();
    public abstract byte getWidth();
}

class Cup extends Container{
    private final int MAX_VOLUME = 250;
    private final byte width = 19;
    @Override
    public int getMaxVolume() {
        return MAX_VOLUME;
    }

    @Override
    public byte getWidth() {
        return width;
    }
}

class Coffeepot extends Container{
    private final int MAX_VOLUME = 1000;
    private final byte width = 25;

    @Override
    public int getMaxVolume() {
        return MAX_VOLUME;
    }
    @Override
    public byte getWidth() {
        return width;
    }
}

class CoffeeMachine{
    public void workSimulation(Container vessel){

        final String vesselName = vessel.getClass().getSimpleName();
        final int vesselMaxVolume = vessel.getMaxVolume();

        System.out.println("This is a simulation of working coffee machine!");
        System.out.println("Pouring...");

        while(!vessel.isFull()){
            if(vessel.getVolume() % 35 == 0 && vessel.getVolume() != 0){
                System.out.printf("%s volume: %dml\n", vesselName, vessel.getVolume());
            }
            vessel.setVolume(vessel.getVolume() + 1);
        }
        
        System.out.printf("%s volume: %dml\n", vesselName, vessel.getVolume());
        System.out.printf("Is %s full? %s\n", vesselName, vessel.isFull());
        System.out.println(vessel);
        System.out.println("Let's drink!");
        while(vessel.getVolume() >= vesselMaxVolume*0.25){
            vessel.setVolume((int)(vessel.getVolume()*0.75));
            System.out.println(vessel);
        }
    }
}
