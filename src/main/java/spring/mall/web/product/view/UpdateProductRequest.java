package spring.mall.web.product.view;

import spring.mall.web.product.model.Product;

public class UpdateProductRequest extends Product {
    public UpdateProductRequest(int id, String name, String description, int price) {
        super(id, name, description, price);
    }
}
