package org.example.linderlindetunmattonlabb3;

import java.util.HashMap;
import java.util.Map;



public class ProductService {

    private final  Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product){
        products.put(product.getId(), product);
    }
    public Product getProduct(String id){
        return products.get(id);
    }
    public void updateProduct(Product product){
        if (products.containsKey(product.getId())){
            products.put(product.getId(), product);
        }
    }
    public void deleteProduct(String id){
        products.remove(id);
    }
}


