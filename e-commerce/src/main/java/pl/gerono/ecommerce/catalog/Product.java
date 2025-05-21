package pl.gerono.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private final UUID productId;
    private final String name;
    private final String description;
    private BigDecimal price;
    private String url;

    public Product(UUID productId, String name, String description) {
        this.productId = productId;
        this.name = name;
        this.description = description;
    }

    public String getId() {return productId.toString();}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public void changePrice(BigDecimal newPrice) throws InvalidProductPriceException {
        if (newPrice != null && newPrice.compareTo(BigDecimal.ZERO) == 1) {
            price = newPrice;
        }
        else {
            throw new InvalidProductPriceException();
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setImage(String url) {
        this.url = url;
    }

    public String getImage() {
        return url;
    }
}
