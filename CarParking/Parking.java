package CarParking;


public class Parking{
    private byte freePlaces; 
    private Car place1A;
    private Car place1B;
    private Car place1C;
    private Car place2A;
    private Car place2B;
    private Car place2C;

    public Parking(byte freePlaces) {
        this.freePlaces = freePlaces;
    }

    public void showFreePlaces(){
        System.out.println(freePlaces);
    }

    public void parkCar(Car c, String place){
        if(freePlaces != 0){
            if(place.equals("1A") && !place.equals(null)){
                this.place1A = c;
            } else if (place.equals("1B") && !place.equals(null)) {
                this.place1B = c;
            } else if (place.equals("1C") && !place.equals(null)) {
                this.place1C = c;
            } else if (place.equals("2A") && !place.equals(null)) {
                this.place2A = c;
            } else if (place.equals("2B") && !place.equals(null)) {
                this.place2B = c;
            } else if (place.equals("2C") && !place.equals(null)) {
                this.place2C = c;
            }
            this.freePlaces--;
        } else {
            System.out.println("No free places");
        }
    }
    
    public String toString(){
        String space = "-18s";
        String parkingMap = String.format(
        "---------------------------------------\n"+
        "|%1$"+space+"|%2$"+space+"|\n"+
        "---------------------------------------\n"+
        "---------------------------------------\n"+
        "|%3$"+space+"|%4$"+space+"|\n"+
        "---------------------------------------\n"+
        "---------------------------------------\n"+
        "|%5$"+space+"|%6$"+space+"|\n"+
        "---------------------------------------",
         place1A, place2A,
         place1B, place2B,
         place1C, place2C);
        return parkingMap;
    }
}
