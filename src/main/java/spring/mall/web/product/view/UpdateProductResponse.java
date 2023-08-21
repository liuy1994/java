package spring.mall.web.product.view;

import spring.mall.web.product.model.Product;

public class UpdateProductResponse extends Product {
    public UpdateProductResponse(int id, String name, String description, int price) {
        super(id, name, description, price);
    }
}