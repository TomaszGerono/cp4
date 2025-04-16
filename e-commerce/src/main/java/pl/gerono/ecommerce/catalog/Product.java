package pl.gerono.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private final UUID productId;
    private final String name;
    private final String description;

    public String getProductId() {
        return productId.toString();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Product(UUID productId, String name, String description) {

        this.productId = productId;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return productId.toString();
    }

    public void changePrice(BigDecimal newPrice) {

    }
}
