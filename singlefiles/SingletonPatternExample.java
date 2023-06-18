package singlefiles;

import java.util.Arrays;

public class SingletonPatternExample {
    public static void main(String[] args) {
        DataColection dataColection = DataColection.getInstance();
        dataColection.add("Foo Bar!");
        dataColection.add("Get your free TV");
        dataColection.add(54);
        dataColection.add(27);
        
        System.out.println(dataColection);
        
        dataColection.removeByIndex(2);
        System.out.println(dataColection);
        
        dataColection.removeByIndex(0);
        System.out.println(dataColection);
        
        
    }
}
class DataColection{
    private Object[] data;
    private static DataColection instance;
    private DataColection() {
        
    }
    public static DataColection getInstance() {
        if (instance == null) {
            instance = new DataColection();
        }
        return instance;
    }
    public void add(Object object) {
        if (data == null) {
            data = new Object[1];
        } else {
            data = Arrays.copyOf(data, data.length + 1);
        }
        data[data.length - 1] = object;
    }
    public void removeByIndex(int index) {
        Object[] newData = new Object[data.length - 1];
        for (int i = 0, j = 0; i < data.length; i++) {
            if (i != index) {
                newData[j++] = data[i];
            } else {
                System.out.println(data[i] + " was deleted.");
            }
        } 
        data = newData;
    }

    @Override
    public String toString() {
        return "DataColection [data=" + Arrays.toString(data) + "]";
    }
    
}