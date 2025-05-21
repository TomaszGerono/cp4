package pl.gerono.ecommerce.catalog;
import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ProductCatalogTest {


    public ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog(
                new HashMapProductRepository()
        );
    }


    @Test
    void itAllowsToLoadAllProductsByTheirId() {
        ProductCatalog productCatalog = thereIsProductCatalog();

        List<Product> products = productCatalog.allProducts();

        assertTrue(products.isEmpty());
    }

    @Test void itCantBeLowerThanZero() {

    }

    @Test
    void itAllowsToAddProducts() {
        ProductCatalog catalog = thereIsProductCatalog();

        catalog.addProduct("lego set 8083", "nice one");

        List<Product> products = catalog.allProducts();
        assertFalse(products.isEmpty());
    }

    @Test
    void catalogIdentifiesProductsWithUniqueIds() {
        ProductCatalog catalog = thereIsProductCatalog();

        String productId1 = catalog.createProduct("Lego set 8083", "nice one");
        String productId2 = catalog.createProduct("Lego set 6285", "even nicer");

        assertNotEquals(productId1, productId2);
    }


    @Test
    void itAllowsToChangePrice() throws InvalidProductPriceException {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.addProduct("Lego set 8083", "nice one");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));
        Product loaded = catalog.loadProductById(id);

        assertEquals(loaded.getPrice(), BigDecimal.valueOf(10.10));
    }

    @Test
    void itAllowsToListProducts() {
        ProductCatalog productCatalog = thereIsProductCatalog();

        List<Product> products = productCatalog.allProducts();

        assertTrue(products.isEmpty());
    }


    @Test
    void itAllowsToChangeImage() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("Lego set 8083", "nice one");

        catalog.changeImage(productId, "https://picsum.photos/id/237/200/300");

        Product loaded = catalog.loadProductById(productId);
        assertEquals("https://picsum.photos/id/237/200/300", loaded.getImage());
    }
}

