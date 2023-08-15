package spring.cart.product.controller.model;

import spring.cart.product.model.Product;

public class UpdateProductRequest extends Product {
    public UpdateProductRequest(int id, String name, String description, int price) {
        super(id, name, description, price);
    }
}
