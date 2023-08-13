package blenderworksimulation;


public class App {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Blender portaBlender = new Blender();
        Fruit apple = new Apple(150);
        Fruit orange = new Orange(250);
        Fruit peach = new Peach(300);
        Juice appleJuice = portaBlender.blend(apple);
        Juice orangeJuice = portaBlender.blend(orange);
        Juice peachJuice = portaBlender.blend(peach);
    }
}
