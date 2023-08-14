package spring.cart.product.model.api;

import spring.cart.product.model.Product;

import java.util.List;

public class ListProductResponse {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
