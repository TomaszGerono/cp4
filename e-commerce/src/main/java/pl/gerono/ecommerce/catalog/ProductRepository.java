package pl.gerono.ecommerce.catalog;

import java.util.List;

public interface ProductRepository {
    List<Product> allProducts();

    void save(Product newProduct);

    Product getProductById(String productId);

}
