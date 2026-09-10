package org.example.linderlindetunmattonlabb3;

import java.util.*;

public class ProductService {

    private final  Map<String, Product> products = Collections.synchronizedMap(new HashMap<>());

    public void addProduct(Product product){
        products.put(product.getId(), product);
    }
    public List<Product> getProducts() { return products.values().stream().toList(); }
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

    public List<Product> getProductsInCategory(String category) {
        return products.values()
                .stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();
    }

    public List<Product> getProductsBelowStockThreshold(int threshold) {
        return products.values()
                .stream()
                .filter(product -> product.getStockBalance() < threshold)
                .toList();
    }
}
