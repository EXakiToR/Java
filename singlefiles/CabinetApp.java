package singlefiles;
//Still contains unhandled exception..
public class CabinetApp {
    public static void main(String[] args) {
        try {
            Cabinet woodCabinet = new Cabinet();
            woodCabinet.putOn("Top shelf", new Perfume("Power"));
            woodCabinet.putOn("middleShelf", new Clothing("White shirt"));
            woodCabinet.putOn("bottom SHELF", new Shoes("Black shoes"));


            woodCabinet.whatIsOn("top shelf");
            woodCabinet.whatIsOn("middle shelf");
            woodCabinet.whatIsOn("bottom shelf");
            
            woodCabinet.takeThingFrom("middleShelf");

        } catch (NoSuchShelfException e) {
            System.err.println("Error: " + e.getMessage() + "\nCan only have top shelf, middle shelf, or bottom shelf.");
        } catch (NullShelfNameException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (NullItemException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

class Cabinet {
    private Shelf topShelf;
    private Shelf middleShelf;
    private Shelf bottomShelf;

    public Cabinet() throws NullShelfNameException{
        topShelf = new Shelf("Top shelf");
        middleShelf = new Shelf("Middle shelf");
        bottomShelf = new Shelf("Bottom shelf");
    }

    public Item whatIsOn(String shelfName) throws NoSuchShelfException, NullShelfNameException {
        checkIfNotNullShelfName(shelfName);
        Shelf shelf = getShelfObjectByName(shelfName);
        Item item = shelf.getItem();
        System.out.println("On " + shelf + " is " + item + " (" + item.getClass().getSimpleName() + ")");
        return item;
    }

    public void putOn(String shelfName, Item item) throws NoSuchShelfException, NullShelfNameException, NullItemException {
        checkIfNotNullShelfName(shelfName);
        Shelf shelf = getShelfObjectByName(shelfName);
        if (item == null) {
            throw new NullItemException("Cannot put null item on " + shelfName.toLowerCase() + ".");
        }
        shelf.put(item);
        System.out.println("You put " + item + " (" + item.getClass().getSimpleName() + ")" + " on " + shelfName.toLowerCase());
    }

    public Item takeThingFrom(String shelfName) throws NoSuchShelfException, NullShelfNameException {
        checkIfNotNullShelfName(shelfName);
        Shelf shelf = getShelfObjectByName(shelfName);
        Item takenItem = shelf.take();
        System.out.println("You've taken " + takenItem + " (" + takenItem.getClass().getSimpleName() + ")" + " from " + shelf);
        return takenItem;
    }

    private Shelf getShelfObjectByName(String shelfName) throws NoSuchShelfException {
        String formattedShelfName = shelfName.replaceAll("\\s", "").toLowerCase();
        switch (formattedShelfName) {
            case "topshelf":
                return topShelf;
            case "middleshelf":
                return middleShelf;
            case "bottomshelf":
                return bottomShelf;
            default:
                throw new NoSuchShelfException("Invalid shelf name: " + shelfName);
        }
    }

    private void checkIfNotNullShelfName(String shelfName) throws NullShelfNameException {
        if (shelfName == null) {
            throw new NullShelfNameException("Null shelf name.");
        }
    }
}

class Shelf {
    private String name;
    private Item item;

    public Shelf(String name) throws NullShelfNameException{
        this.name = name;
    }

    public void put(Item item) {
        this.item = item;
    }

    public Item take() {
        Item takenItem = item;
        item = null;
        return takenItem;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return name;
    }
}

abstract class Item {
    private String name;

    public Item(String name) throws NullItemException {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NullItemException {
        if (name == null) {
            throw new NullItemException("Null name of an item.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Perfume extends Item {
    public Perfume(String name) throws NullItemException {
        super(name);
    }
}

class Clothing extends Item {
    public Clothing(String name) throws NullItemException {
        super(name);
    }
}

class Shoes extends Item {
    public Shoes(String name) throws NullItemException {
        super(name);
    }
}

class NoSuchShelfException extends Exception {
    public NoSuchShelfException(String message) {
        super(message);
    }
}

class NullShelfNameException extends Exception {
    public NullShelfNameException(String message) {
        super(message);
    }
}

class NullItemException extends Exception {
    public NullItemException(String message) {
        super(message);
    }
}
