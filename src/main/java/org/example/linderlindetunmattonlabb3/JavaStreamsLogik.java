package org.example.linderlindetunmattonlabb3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class LinderLindetunMattonLabb3Application {

    public static void main(String[] args) {
        SpringApplication.run(LinderLindetunMattonLabb3Application.class, args);
    }

}

public class ProductService {

    private final  Map<String, Product> products = new Hashmap<>();

    public void addProduct(Product product){
        product.put(product.getId(), product);
    }
    public Product getProduct(String id){
        return products.get(id);
    }
    public void updateProduct(product product){
        if (product.containsKey(product.getId())){
            product.put(product.getId(), product);
        }
    }
    public void deleteProduct(String id){
        products.remove(id);
    }
}

public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
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
}


ProductService service = new ProductService();

Product product = new Product("1","Kaffe", 75,99);

service.addProduct(product);

Product foundProduct = service.getProduct("1");

System.out.println(foundProduct.getName());
