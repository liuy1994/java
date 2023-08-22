package spring.mall.web.cart.model;

import spring.mall.web.product.model.Product;

import jakarta.persistence.*;
import spring.mall.web.user.model.User;

@Entity
@Table(name = "cart")
public class CartItem  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product products;

    @Column(name = "quantity")
    private int quantity;

}
