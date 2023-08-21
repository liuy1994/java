package spring.mall.web.product.view;

import spring.mall.web.product.model.Product;

import java.util.List;

public class ListProductResponse {
    private List<Product> products;

    public ListProductResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
