package spring.mall.web.product.view;

import spring.mall.web.product.model.Product;

public class CreateProductRequest extends Product {
    public CreateProductRequest(String name, String description, int price) {
        super(name, description, price);
    }
}
