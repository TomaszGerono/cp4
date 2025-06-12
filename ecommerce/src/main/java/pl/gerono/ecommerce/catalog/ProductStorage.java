package pl.gerono.ecommerce.catalog;

import java.util.List;

public interface ProductStorage {
    List<Product> allProducts();

    void save(Product newProduct);

    // Product getProductById(String productId);

    Product loadProductById(String productId);
}