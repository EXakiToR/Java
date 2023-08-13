package transportation;


public class Car extends ATransport{
    private Driver fl;
    private ITransportable fr;
    private ITransportable bl;
    private ITransportable br;


    
    public ITransportable getThingFromPlace(String place) {
        if (place.toLowerCase().equals("fl")){
            return fl;
        }
        else if (place.toLowerCase().equals("fr")){
            return fr;
        }
        else if (place.toLowerCase().equals("bl")){
            return bl;
        }
        else if (place.toLowerCase().equals("br")){
            return br;
        }
        return null;
    }



    public void setThingToPlace(String place, ITransportable thing) {
        if (place.toLowerCase().equals("fl")){
            fl = (Driver)thing;
        }
        else if (place.toLowerCase().equals("fr")){
            fr = thing;
        }
        else if (place.toLowerCase().equals("bl")){
            bl = thing;
        }
        else if (place.toLowerCase().equals("br")){
            br = thing;
        }

    }



    public String toString(){
        return 
        "+---------Object<Car>--------+\n"+
        "|                            |\n"+
        "|                            |\n"+
        "|  +----+          +----+    |\n"+
        "|  |"+fl+"|          |"+fr+"|    |\n"+
        "|  +----+          +----+    |\n"+
        "|                            |\n"+
        "|                            |\n"+
        "|  +----+          +----+    |\n"+
        "|  |"+bl+"|          |"+br+"|    |\n"+
        "|  +----+          +----+    |\n"+
        "|                            |\n"+
        "+----------------------------+\n";
        
    }
}
