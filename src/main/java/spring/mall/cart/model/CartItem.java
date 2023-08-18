package spring.mall.cart.model;

import spring.mall.product.model.Product;
import spring.mall.user.model.User;

import jakarta.persistence.*;

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
