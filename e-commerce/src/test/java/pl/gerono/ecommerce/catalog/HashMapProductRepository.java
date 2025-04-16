package pl.gerono.ecommerce.catalog;

import pl.gerono.ecommerce.catalog.Product;
import pl.gerono.ecommerce.catalog.ProductRepository;

import java.util.List;

public class HashMapProductRepository implements ProductRepository {

    @Override
    public List<Product> allProducts() {
        return null;
    }

    @Override
    public void save(Product newProduct) {

    }

    @Override
    public Product getProductById(String productId) {
        return null;
    }

}
