package com.pluralsight.NorthWindTradersAPI.models;

public class Product {
   private int productID, categoryID;
   private String productName;
   private double unitPrice;

    public Product(int productID, int categoryID, String productName, double unitPrice) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.unitPrice = unitPrice;
    }

    public Product(){
        this.productID = 3;
        this.categoryID = 3;
        this.productName = "Bike";
        this.unitPrice = 2300;

    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", categoryID=" + categoryID +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
