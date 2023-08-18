package spring.mall.cart.model;

import spring.mall.product.model.Product;

public class Item extends Product {
    private int num;
    public Item(int id, String name, String description, int price) {
        super(id, name, description, price);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
