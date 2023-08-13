package blenderworksimulation;

public class Apple extends Fruit{

    public Apple(int weight){
        super(weight); //If just for Fruit() constructor, then super(); instead of super(weight); 
        setJuiceOutcome(60);
    }
}
