package com.pluralsight.NorthWindTradersAPI.controllers;
import com.pluralsight.NorthWindTradersAPI.models.Category;
import com.pluralsight.NorthWindTradersAPI.models.Product;
import com.pluralsight.NorthWindTradersAPI.models.Store;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductsController {

    @RequestMapping(path="/products", method = RequestMethod.GET)
    public ArrayList<Product> products(

    ){
       Store store = new Store();
        return store.getAllProducts();
    }

    @RequestMapping(path="/products/{id}",method = RequestMethod.GET)
    public ArrayList<Product> prodByID( @PathVariable int id){
       Store store = new Store();
        return store.getByID(id);
    }

    @RequestMapping(path="/categories", method = RequestMethod.GET)
    public ArrayList<Category> categories(

    ){
        Store store = new Store();
        return store.getAllCategories();
    }

    @RequestMapping(path="/categories/{id}",method = RequestMethod.GET)
    public ArrayList<Category> catByID( @PathVariable int id){
        Store store = new Store();
        return store.getCategoryByID(id);
    }


}
