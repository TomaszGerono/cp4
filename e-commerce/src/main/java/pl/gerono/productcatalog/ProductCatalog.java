package pl.gerono.productcatalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {

    private List<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);
    }

    public String createProduct(String name, String description) {

        UUID productId = UUID.randomUUID();

        var newProduct = new Product(
                productId,
                name,
                description
        );

        products.add(newProduct);
        return newProduct.getId();
    }
}
