package pl.gerono.ecommerce.catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListProductRepository implements ProductStorage {

    private List<Product> products;

    public ArrayListProductRepository() {
        this.products = new ArrayList<>();  // TECH
    }

    @Override
    public List<Product> allProducts() {
        return Collections.unmodifiableList(this.products); // TECH
    }

    @Override
    public void save(Product newProduct) {
        this.products.add(newProduct);
    }

    @Override
    public Product loadProductById(String productId) {
        return this.products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .get(); // TECH
    }
}
