package spring.mall.web.order.model;

import spring.mall.web.product.model.Product;
import spring.mall.web.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private Product products;

    private int quantity;

    private int status;

    private String address;
}
