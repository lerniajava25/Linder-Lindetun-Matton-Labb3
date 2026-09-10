package org.example.linderlindetunmattonlabb3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
    public void deleteProduct(String id){
        products.remove(id);
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


