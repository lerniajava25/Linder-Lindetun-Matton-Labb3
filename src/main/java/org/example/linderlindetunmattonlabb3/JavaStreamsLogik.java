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
