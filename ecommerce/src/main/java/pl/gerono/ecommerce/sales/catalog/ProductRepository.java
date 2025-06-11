package pl.gerono.ecommerce.sales.catalog;

import java.util.List;

public interface ProductRepository {
    List<Product> allProducts();

    void save(Product newProduct);

    // Product getProductById(String productId);

    Product loadProductById(String productId);
}