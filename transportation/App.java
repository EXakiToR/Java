package transportation;

public class App {
    public static void main(String[] args) {
        Driver brother = new Driver();
        ABeing dog = new Dog();
        ABeing cat = new Cat();

        ATransport bmw = new Car();
    
        ((Car)bmw).setThingToPlace("fl", brother);
        ((Car)bmw).setThingToPlace("bl", dog);
        ((Car)bmw).setThingToPlace("br", cat);
        System.out.println(bmw);
    }
   
}
