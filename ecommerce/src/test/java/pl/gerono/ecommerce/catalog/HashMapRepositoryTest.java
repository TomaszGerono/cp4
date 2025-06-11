package pl.gerono.ecommerce.catalog;

import org.junit.jupiter.api.Test;
import pl.gerono.ecommerce.sales.catalog.HashMapProductRepository;
import pl.gerono.ecommerce.sales.catalog.InvalidProductPriceException;
import pl.gerono.ecommerce.sales.catalog.Product;
import pl.gerono.ecommerce.sales.catalog.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapRepositoryTest {

    private ProductRepository thereIsProductRepository() {
        return new HashMapProductRepository();
    }



    private Product thereIsProduct() throws InvalidProductPriceException {
        var product = new Product(UUID.randomUUID(), "example product name", "example product description");
        product.changePrice(BigDecimal.valueOf(10.10));
        return product;
    }




    @Test
    void itStoresAndLoadsProduct() throws InvalidProductPriceException {
        // Arange
        var product = thereIsProduct();
        var repository = thereIsProductRepository();

        // Act
        repository.save(product);
        var loaded = repository.loadProductById(product.getId());

        // Assert
        assertEquals(product.getId(), loaded.getId());
        assertEquals(product.getName(), loaded.getName());
    }




    @Test
    void itStoreAndLoadsProductById() throws InvalidProductPriceException {
        var product = thereIsProduct();
        var repository = thereIsProductRepository();

        repository.save(product);
        var loaded = repository.loadProductById(product.getId());

        assertEquals(product.getId(), loaded.getId());
    }




    @Test
    void itLoadsAllProducts() throws InvalidProductPriceException {
        Product product = thereIsProduct();
        ProductRepository repository = thereIsProductRepository();

        repository.save(product);

        List<Product> products = repository.allProducts();

        assertEquals(1, products.size());
    }
}
