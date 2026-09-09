package org.example.linderlindetunmattonlabb3;

import java.time.LocalDate;


public class Product {
    private String id;
    private String name;
    private double price;
    private String category;
    private int stockBalance;
    private LocalDate expirationDate;
    private LocalDate registrationDate;


    public Product(String id, String name, double price, String category, int stockBalance, LocalDate expirationDate, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockBalance = stockBalance;
        this.expirationDate = expirationDate;
        this.registrationDate = registrationDate;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getCategory(){
        return category;
    }
    public int getStockBalance(){
        return stockBalance;
    }
    public LocalDate getExpirationDate(){
        return expirationDate;
    }
    public LocalDate getRegistrationDate(){
        return registrationDate;
    }
}
