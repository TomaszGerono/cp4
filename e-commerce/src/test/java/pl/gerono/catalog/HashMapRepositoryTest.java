package pl.gerono.catalog;

import org.junit.jupiter.api.Test;
import pl.gerono.ecommerce.catalog.Product;
import pl.gerono.ecommerce.catalog.ProductRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapRepositoryTest {
    @Test
    void itStoresAndLoadsProduct() {
        // Arange
        Product product = thereIsProduct();
        ProductRepository repository = thereIsProductRepository();

        // Act
        repository.save(product);

        Product loaded = repository.getProductById(product.getId());

        // Assert
        assertEquals(product.getId(), loaded.getId());
        assertEquals(product.getName(), loaded.getDescription());
    }

    private ProductRepository thereIsProductRepository() {
        return null;
    }

    private Product thereIsProduct() {
        return null;
    }

    @Test
    void itLoadsAllProducts() {
        Product product = thereIsProduct();
        ProductRepository repository = thereIsProductRepository();

        repository.save(product);

        List<Product> products = repository.allProducts();

        assertEquals(1, products.size());
    }
}
