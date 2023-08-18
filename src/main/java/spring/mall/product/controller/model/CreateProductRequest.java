package spring.mall.product.controller.model;

import spring.mall.product.model.Product;

public class CreateProductRequest extends Product {
    public CreateProductRequest(String name, String description, int price) {
        super(name, description, price);
    }
}
