package pl.gerono.productcatalog;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseProductRepositoryTest {



    @Test
    void itStoresAndLoadsProduct() {
        Product product = thereIsProduct();
        ProductRepository repository = thereIsProductRepository();

        repository.save(product);

        Product loaded = repository.loadProductById(product.getId());

        assertEquals(product.getId(), loaded.getId());
        assertEquals(product.getName(), loaded.getDescription());
    }

    private ProductRepository thereIsProductRepository() {
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

    private Product thereIsProduct() {
        return null;
    }
}
