package CarParking;


public class Car {
    private String model;
    private String id;

    public Car(String model, String id) {
        setModelAndId(model, id);
    }

    public String getModelAndId() {
        return model + " [" + id + "]";
    }

    public void setModelAndId(String model, String id) {
        if (model.equals("BMW") || model.equals("Mercedes") || model.equals("Fiat")){
            this.model = model;
            this.id = id;
        } else {
            System.err.println("Can't park this car model");
        }
        
    }

    
    
    public String toString(){
        return getModelAndId();
    }
}
