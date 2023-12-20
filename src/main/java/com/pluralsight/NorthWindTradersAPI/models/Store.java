package com.pluralsight.NorthWindTradersAPI.models;

import java.util.ArrayList;

public class Store {

    private ArrayList<Product> inventory;
    private ArrayList<Category> categories;

    Product eggs = new Product(1,1,"Eggs",2.50);
    Product bread = new Product(2,1,"Bread",3.50);
    Product milk = new Product(3,1,"Eggs",5.50);
    Product shoes = new Product(4,2,"Shoes",67.99);
    Product socks = new Product(5,2,"Socks",7.50);
    Category food = new Category(1,"Food");
    Category clothes = new Category(2,"Clothes");


    public Store() {
        this.inventory = new ArrayList<>();
        this.categories = new ArrayList<>();
        inventory.add(eggs);
        inventory.add(bread);
        inventory.add(milk);
        inventory.add(shoes);
        inventory.add(socks);
        categories.add(food);
        categories.add(clothes);
    }


    public ArrayList<Product> getAllProducts() {

        ArrayList<Product> prodList = new ArrayList<>();
        for(Product prod : inventory){
            prodList.add(prod);
        }

        return prodList;
    }

    public ArrayList<Category> getAllCategories() {

        ArrayList<Category> catList = new ArrayList<>();
        for(Category cat : categories){
            catList.add(cat);
        }

        return catList;
    }


    public ArrayList<Product> getByID(int id){
        ArrayList<Product> prodList = new ArrayList<>();
        for(Product prod : inventory){
            if(id == prod.getProductID()){
                prodList.add(prod);
            }
        }
        return prodList;
    }

    public ArrayList<Category> getCategoryByID(int id){
        ArrayList<Category> catList = new ArrayList<>();
        for(Category cat : categories){
            if(id == cat.getCategoryID()){
                catList.add(cat);
            }
        }
        return catList;
    }

}
