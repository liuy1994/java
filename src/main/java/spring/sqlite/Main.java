package spring.sqlite;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:identifier.sqlite");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
//            statement.executeUpdate("insert into product(id, name, price, desc) values (2, 'goods_02', 2000, 'ahhahah2')");
//            statement.executeUpdate("insert into product(id, name, price, desc) values (3, 'goods_03', 3000, 'ahhahah3')");
            ResultSet rs = statement.executeQuery("select * from product");

            while (rs.next()) {
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
