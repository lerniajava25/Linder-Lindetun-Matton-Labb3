package org.example.linderlindetunmattonlabb3;

import java.util.*;

public class ProductService {

    private final  Map<String, Product> products = Collections.synchronizedMap(new HashMap<>());

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

    public List<Product> getMostExpensiveProducts(int n){
        if (n < 0){
            throw new IllegalArgumentException("The number of products can not be negative");
        }

        return products
                .values()
                .stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(n)
                .toList();
    }

    public void deleteProduct(String id){
        products.remove(id);
    }
}
