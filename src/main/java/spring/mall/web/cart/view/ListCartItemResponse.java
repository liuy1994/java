package spring.mall.web.cart.view;

import spring.mall.web.cart.model.CartItem;
import spring.mall.web.product.model.Product;

import java.util.List;

public class ListCartItemResponse {
    private List<CartItem> cartItems;

    public ListCartItemResponse(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
