package spring.mall.web.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import spring.mall.web.cart.model.CartItem;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "user")
    private List<CartItem> cartItems;

    public User() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
