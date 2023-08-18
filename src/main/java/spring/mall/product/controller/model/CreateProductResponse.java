package spring.mall.product.controller.model;

import spring.mall.product.model.Product;

public class CreateProductResponse extends Product {

    public CreateProductResponse(int id, String name, String description, int price) {
        super(id, name, description, price);
    }
}
