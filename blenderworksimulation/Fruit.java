package blenderworksimulation;


abstract public class Fruit {
    private int weight;

    private int juiceOutcome;
        
    public int getJuiceOutcome() {
        return juiceOutcome;
    }
    public void setJuiceOutcome(int juiceOutcome) {
        if(juiceOutcome > 0){
            this.juiceOutcome = juiceOutcome;
        }

    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if(weight > 0){
            this.weight = weight;
        }

    }

    public Fruit(){}
    public Fruit(int weight){
        setWeight(weight);
    }
}
