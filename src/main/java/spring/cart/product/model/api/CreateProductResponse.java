package spring.cart.product.model.api;

import spring.cart.product.model.Product;

public class CreateProductResponse extends Product {

    public CreateProductResponse(int id, String name, String description, int price) {
        super(id, name, description, price);
    }
}
