package eshop.orm.entities;

public class Product extends Entity{
    private int id;
    private String name, image;
    public Product(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
    public Product(String name, String image) {
        this.name = name;
        this.image = image;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public String toString() {
        return super.toString() + ", Product [id=" + id + ", name=" + name + ", image=" + image + "]";
    }

    
}
