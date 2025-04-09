package pl.gerono.productcatalog;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ProductCatalogTest {


    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog(
                new HashMapProductRepositoryTest(

                );
        );
    }


    @Test
    void itAllowsToLoadProductsByItsId() {

    }

    @Test void itCantBeLowerThanZero() {

    }

    @Test
    void itAllowsToAddProducts() {
        ProductCatalog catalog = thereIsProductCatalog();

        catalog.createProduct("lego set 8083", "nice one");

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
    void itAllowsToChangeImage() {
//        ProductCatalog catalog = thereIsProductCatalog();
//        String productId = catalog.createProduct("Lego set 8083", "nice one");
//
//        catalog.changeImage(productId, "https://picsum.photos/id/237/200/300");
//
//        Product loaded = catalog.loadProductById(productId);
//        assertEquals("https://picsum.photos/id/237/200/300", loaded.getImage());
   }


    @Test
    void itAllowsToChangePrice() {

    }

    @Test
    void itAllowsToListProducts() {
        ProductCatalog catalog = thereIsProductCatalog();

        List<Product> products = catalog.allProducts();

        assertTrue(products.isEmpty());

    }

}

