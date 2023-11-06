package com.codewithsanjay.Dao;

import com.codewithsanjay.db.Database;
import com.codewithsanjay.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDao {
    private static String SELECT_QUERY = "SELECT * FROM Product ";
    static Connection connection;


    public ProductDao() throws SQLException, ClassNotFoundException {
        connection = Database.getconnection();
    }

    public static List<Product> getproducts() throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
        ResultSet set = preparedStatement.executeQuery();
        List<Product> product = new ArrayList<>();
        while (set.next()) {
            Product prod = new Product();
            prod.setId(set.getInt("id"));
            prod.setTitle(set.getString("title"));
            prod.setPrice(set.getInt("price"));
            prod.setImage(set.getString("image"));
            product.add(prod);
        }

        return product;
    }
}