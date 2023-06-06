package singlefiles;

public class DeleteOrAddArrayElement {
    public static void main(String[] args) {
        
        int[] data = {10,20,30,40,50},
        newDataArrayDecremented = new int[data.length - 1],
        newDataArrayIncremented = new int[data.length + 1];
        int indexToDelete = 2, indexToInsert = 2, newValue = -10;

        for(int oi = 0, ni = 0; oi < data.length; oi++)
        {
            if(oi != indexToDelete){
                newDataArrayDecremented[ni++] = data[oi];
            }
        }
        for(int oi = 0, ni = 0; oi < data.length; oi++, ni++)
        {
            if(oi == indexToInsert){
                newDataArrayIncremented[ni++] = newValue;
            }
            newDataArrayIncremented[ni] = data[oi];
            
        }
    
        data = newDataArrayDecremented;
        for (int elem : newDataArrayDecremented) {
            System.out.print(elem + " ");
        }
        System.out.println();
        data = newDataArrayIncremented;
        for (int elem : newDataArrayIncremented) {
            System.out.print(elem + " ");
        }
        System.out.println();

        Person[] people = new Person[5],
        newPeopleArrayDecremented = new Person[people.length - 1],
        newPeopleArrayIncremented = new Person[people.length + 1];
        Person newPerson = new Person("David Peterson");

        String[] names = {"John Doe", "Jane Smith", "Alice Johnson", "Bob Williams", "Emily Brown"};

        for (int i = 0; i < people.length; i++) {
            people[i] = new Person(names[i]);   
        }
        for(int oi = 0, ni = 0; oi < people.length; oi++)
        {
            if(oi != indexToDelete){
                newPeopleArrayDecremented[ni++] = people[oi];
            }
        }
        for(int oi = 0, ni = 0; oi < people.length; oi++, ni++)
        {
            if(oi == indexToInsert){
                newPeopleArrayIncremented[ni++] = newPerson;
            }
            newPeopleArrayIncremented[ni] = people[oi];
            
        }

        for (Person person : newPeopleArrayDecremented) {
            System.out.print(person.getFullName() + ", ");
        }
        System.out.println();
        for (Person person : newPeopleArrayIncremented) {
            System.out.print(person.getFullName() + ", ");
        }
        System.out.print("\b\b");
    }
}

class Person{
    private String fullName;

    public Person(String fullName) {
        setFullName(fullName);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}

