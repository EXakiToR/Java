package carparking;


class Parking {
    private byte freePlaces;
    private Car[] parkingPlaces;

    Parking(byte freePlaces) {
        this.freePlaces = freePlaces;
        this.parkingPlaces = new Car[freePlaces];
    }

    void showFreePlaces() {
        System.out.println(freePlaces);
    }

    void parkCar(Car car, String place) {
        if (freePlaces != 0) {
            int placeIndex = getPlaceIndex(place);
            if (placeIndex != -1) {
                if (parkingPlaces[placeIndex] == null) {
                    parkingPlaces[placeIndex] = car;
                    freePlaces--;
                } else {
                    System.out.println("Place "+place+" is already occupied.");
                }
            } else {
                System.out.println("Invalid place: "+place);
            }
        } else {
            System.out.println("No free places.");
        }
    }

    private int getPlaceIndex(String place) {
        switch (place) {
            case "1A":
                return 0;
            case "2A":
                return 1;
            case "1B":
                return 2;
            case "2B":
                return 3;
            case "1C":
                return 4;
            case "2C":
                return 5;
            default:
                return -1;
        }
    }

    public String toString() {
        String carSpace = "%-18s";
        StringBuilder parkingMap = new StringBuilder("---------------------------------------\n");
        for (int i = 0; i < 3; i++) {
            parkingMap.append(String.format("|"+carSpace+"|"+carSpace+"|\n",
                    parkingPlaces[i * 2], parkingPlaces[i * 2 + 1]));
            parkingMap.append("---------------------------------------\n");
        }
        return parkingMap.toString();
    }
}
