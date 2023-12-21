package com.pluralsight.NorthWindTradersAPI;

import com.pluralsight.NorthWindTradersAPI.models.Category;
import com.pluralsight.NorthWindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Component
public class JdbcCategoryDAO {





        private ArrayList<Category> products;
        private DataSource dataSource;
        @Autowired
        public JdbcCategoryDAO(DataSource basicdataSource){
            this.products = new ArrayList<>();
            this.dataSource = basicdataSource;
        }

        public ArrayList<Category> getAll() {
            ArrayList<Category> Categories = new ArrayList<>();
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM categories")) {

                while(resultSet.next()){
                    Category c = new Category(
                            resultSet.getInt("CategoryID"),
                            resultSet.getString("CategoryName")

                    );
                    products.add(c);
                }

            }catch (SQLException e){
                e.printStackTrace();
            }

            return products;
        }

        public ArrayList<Category> getCategoryByID(int id) {
            ArrayList<Category> categories = new ArrayList<>();
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM categories WHERE CategoryID = ?");)
            {
                statement.setInt(1,id);
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()){
                    Category c = new Category(
                            resultSet.getInt("CategoryID"),
                            resultSet.getString("CategoryName")
                    );
                    products.add(c);
                }

            }catch (SQLException e){
                e.printStackTrace();
            }

            return products;
        }


    public void getNewCategory(Category category){
        String sql ="INSERT INTO categories (CategoryName) VALUES (?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1,category.getCategoryName());
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    }


