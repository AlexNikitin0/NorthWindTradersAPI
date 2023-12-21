package com.pluralsight.NorthWindTradersAPI;

import com.pluralsight.NorthWindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
@Component
public class JdbcProductDAO {

    private ArrayList<Product> products;
    private DataSource dataSource;
    @Autowired
    public JdbcProductDAO(DataSource basicdataSource){
        this.products = new ArrayList<>();
        this.dataSource = basicdataSource;
    }

    public ArrayList<Product> getAll() {
        ArrayList<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM products")) {

            while(resultSet.next()){
                Product p = new Product(
                        resultSet.getInt("ProductID"),
                        resultSet.getInt("CategoryID"),
                        resultSet.getString("ProductName"),
                        resultSet.getDouble("UnitPrice")
                );
                products.add(p);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return products;
    }

    public ArrayList<Product> getProductByID(int id) {
        ArrayList<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM products WHERE ProductID = ?");)
             {
             statement.setInt(1,id);
             ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Product p = new Product(
                        resultSet.getInt("ProductID"),
                        resultSet.getInt("CategoryID"),
                        resultSet.getString("ProductName"),
                        resultSet.getDouble("UnitPrice")
                );
                products.add(p);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return products;
    }

        //post
    public void getNewProduct(Product product){
        String sql ="INSERT INTO products (ProductName,CategoryID,UnitPrice) VALUES (?,?,?)";
        ArrayList<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ) {
            statement.setString(1,product.getProductName());
            statement.setInt(2,product.getCategoryID());
            statement.setDouble(3,product.getUnitPrice());
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    }




