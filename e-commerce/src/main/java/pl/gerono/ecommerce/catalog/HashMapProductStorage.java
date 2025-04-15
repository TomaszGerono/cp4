package pl.gerono.ecommerce.catalog;

import java.util.HashMap;
import java.util.List;

public class HashMapProductStorage implements ProductRepository {

    HashMap<String, Product> productHashMap;

    public HashMapProductStorage() {
        this.productHashMap = new HashMap<>();
    }

    @Override
    public List<Product> allProducts() {
        return productHashMap.values().stream().toList();
    }

    @Override
    public void save(Product product) {
        productHashMap.put(product.getId(), product);
    }

    @Override
    public Product getProductById(String id) {
        return productHashMap.get(id);
    }
}