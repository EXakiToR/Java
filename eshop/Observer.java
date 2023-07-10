package eshop;

public class Observer {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.subscribe(new Client("James R. Brown"));
        shop.subscribe(new Client("Susan P. Sawyer"));
        System.out.println("Shop's subscribers: ");
        for (Client client : shop.clients) {
            if (client != null) {
                System.out.println("\t" + client.fullName);
            }
        }
        shop.addProduct(new Product("Carpet"));
        shop.addProduct(new Product("Lawn mower"));
    }
}

class Shop {
    public Product[] products = new Product[5];
    public Client[] clients = new Client[10];

    private void addNewTo(Object[] dataArray, Object object) {
        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i] == null) {
                dataArray[i] = object;
                break;
            }
        }
    }

    public void addProduct(Product product) {
        addNewTo(products, product);
        for (Client client : clients) {
            if (client != null) {
                client.notify(product);
                
            }
        }
    }

    public void subscribe(Client client) {
        addNewTo(clients, client);
    }

    public void unsubscribeByIndex(int index) {
        Client[] newClientArray = new Client[clients.length - 1];
        for (int i = 0, j = 0; i < clients.length; i++) {
            if (i != index) {
                newClientArray[j++] = clients[i];
            } else {
                System.out.println(clients[i] + " was unsubscribed.");
            }
        }
        clients = newClientArray;
    }
}

class Product {
    public String name;

    public Product(String name) {
        this.name = name;
    }

}

class Client {
    public String fullName;

    public Client(String fullName) {
        this.fullName = fullName;
    }

    public void notify(Product product) {
        System.out.printf("\n%s, a new product has appeared: %s.\n", fullName, product.name);
    }
}