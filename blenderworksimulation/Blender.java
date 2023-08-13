package blenderworksimulation;

public class Blender {
    public Juice blend(Fruit fruit){
        Juice juice = new Juice(fruit.getWeight() * fruit.getJuiceOutcome() / 100);
        System.out.printf("From %d gr of %s you've got %d ml of juice!\n", fruit.getWeight(),
        fruit.getClass().getSimpleName().toLowerCase(), juice.getVolume());
        return juice;
    }
}
