package spring.cart.product.model;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class ProductDao {
    private Statement statement;

    public ProductDao(Statement statement) {
        this.statement = statement;
        try {
            ResultSet rs = statement.executeQuery("select * from product");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Fail to query list: " + e.getMessage());
        }
    }


    public Product get(int id) {
        try {
            System.out.println("开始查询商品详情");
            String query = "select * from product where id = " + id;
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                System.out.println("Find one product");
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("desc"),
                        rs.getInt("price")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Fail to query product: " + e.getMessage());
        }
        return null;
    }
}
