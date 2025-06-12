package pl.gerono.ecommerce.catalog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class ProductController {

    ProductCatalog productCatalog;

    public ProductController(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    @GetMapping("/api/version")
    String version() {
        return "0.0.1";
    }

    @GetMapping("/api/products")
    List<Product> allProducts() {
        return productCatalog.allProducts();
    }
}