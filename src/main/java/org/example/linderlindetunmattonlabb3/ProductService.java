package org.example.linderlindetunmattonlabb3;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
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

    public List<Product> getProductsInCategory(String category) {
        if(category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category can not be null or blank");
        }

        return products.values()
                .stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();
    }

    public List<Product> getProductsBelowStockThreshold(int threshold) {
        if(threshold < 0) {
            throw new IllegalArgumentException("The stock threshold can not be negative");
        }

        return products.values()
                .stream()
                .filter(product -> product.getStockBalance() < threshold)
                .toList();
    }

    public Map<String, Double> getTotalStockValueByCategory() {
        return products.values()
        .stream()
                .collect(Collectors.groupingBy(Product::getCategory,Collectors.summingDouble(product -> product.getStockBalance() * product.getPrice()
                )
                ));

    }
    public Map<String, Double> getAveragePriceByCategory(){
        return products.values()
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
    }
}
