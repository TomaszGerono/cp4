package pl.gerono.productcatalog;

import java.util.UUID;

public class Product {

    private final UUID productId;
    private final String name;
    private final String description;

    public Product(UUID productId, String name, String description) {

        this.productId = productId;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return productId.toString();
    }
}
