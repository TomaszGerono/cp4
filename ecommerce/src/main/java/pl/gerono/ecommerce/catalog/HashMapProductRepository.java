package pl.gerono.ecommerce.catalog;

import java.util.HashMap;
import java.util.List;

public class HashMapProductRepository implements ProductStorage {

    HashMap<String, Product> productHashMap;

    public HashMapProductRepository() {
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
    public Product loadProductById(String productId) {
        return productHashMap.get(productId);
    }
}
