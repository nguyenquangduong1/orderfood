package com.example.nguyenquangduong.totnghiep.Model;

public class Order {
    private int ID;
    private String Productld;
    private String ProductName;
    private String Quantity;
    private String Price;
    private  String Discount;

    public Order() {
    }

    public Order(String productld, String productName, String quantity, String price, String discount) {
        Productld = productld;
        ProductName = productName;
        Quantity = quantity;
        Price = price;
        Discount = discount;
    }

    public Order(String phone, String foodId, String foodName, String s, String foodPrice, String foodDiscount, String foodImage) {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Order(int ID, String productld, String productName, String quantity, String price, String discount) {
        this.ID = ID;
        Productld = productld;
        ProductName = productName;
        Quantity = quantity;
        Price = price;
        Discount = discount;
    }

    public String getProductld() {
        return Productld;
    }

    public void setProductld(String productld) {
        Productld = productld;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }
}
