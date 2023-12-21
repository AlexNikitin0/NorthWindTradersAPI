package com.pluralsight.NorthWindTradersAPI.controllers;
import com.pluralsight.NorthWindTradersAPI.JdbcCategoryDAO;
import com.pluralsight.NorthWindTradersAPI.JdbcProductDAO;

import com.pluralsight.NorthWindTradersAPI.models.Category;
import com.pluralsight.NorthWindTradersAPI.models.Product;
import com.pluralsight.NorthWindTradersAPI.models.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductsController {
   private JdbcProductDAO jdbcProductDAO;
   private JdbcCategoryDAO jdbcCategoryDAO;
    @Autowired
    public ProductsController(JdbcProductDAO jdbcProductDAO, JdbcCategoryDAO jdbcCategoryDAO) {
        this.jdbcProductDAO = jdbcProductDAO;
        this.jdbcCategoryDAO = jdbcCategoryDAO;
    }

    @RequestMapping(path="/products", method = RequestMethod.GET)
    public ArrayList<Product> products(

    ){
     return jdbcProductDAO.getAll();
    }

    @RequestMapping(path="/products/{id}",method = RequestMethod.GET)
    public ArrayList<Product> prodByID( @PathVariable int id){
    return jdbcProductDAO.getProductByID(id);
    }

    @RequestMapping(path="/categories", method = RequestMethod.GET)
    public ArrayList<Category> categories(

    ){
       return jdbcCategoryDAO.getAll();
    }

    @RequestMapping(path="/categories/{id}",method = RequestMethod.GET)
    public ArrayList<Category> catByID( @PathVariable int id){
        return jdbcCategoryDAO.getCategoryByID(id);
    }


}
