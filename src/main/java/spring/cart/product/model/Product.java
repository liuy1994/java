package spring.cart.product.model;

public class Product {

    private int id;
    private String name;
    private String desc;
    private long price;

    public Product(String name, String desc, int price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }
    public Product(int id, String name, String desc, int price) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
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

    public String getDescription() {
        return desc;
    }

    public void setDescription(String desc) {
        this.desc = desc;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
