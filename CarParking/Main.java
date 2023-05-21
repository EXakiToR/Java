package CarParking;

public class Main {
    public static void main(String[] args) {
        Parking p1 = new Parking((byte)6);
        Car c1 = new Car("BMW", "ABC-456");
        Car c2 = new Car("Fiat", "TAR-963");
        Car c3 = new Car("Mercedes", "UYI-128");
        p1.showFreePlaces();
        p1.parkCar(c1, "1B");
        p1.parkCar(c2, "2C");
        p1.parkCar(c3, "2C");

        System.out.println(p1);
        p1.showFreePlaces();
    }
}
