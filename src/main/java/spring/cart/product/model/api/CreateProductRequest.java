package spring.cart.product.model.api;

import spring.cart.product.model.Product;

public class CreateProductRequest extends Product {
    public CreateProductRequest(String name, String description, int price) {
        super(name, description, price);
    }
}
