package spring.cart.cart.model;

import spring.cart.product.model.Product;

import java.awt.*;

public class Item extends Product {
    private int num;
    public Item(String id, String name, String description, long price) {
        super(id, name, description, price);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}