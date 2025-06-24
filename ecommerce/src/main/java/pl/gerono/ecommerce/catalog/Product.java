package pl.gerono.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private final String id;
    private final String name;
    private final String description;
    private BigDecimal price;
    private String image;

    public Product(UUID id, String name, String description) {
        this.id = id.toString();
        this.name = name;
        this.description = description;
    }

    public Product(String id, String name, String description, BigDecimal price, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void changePrice(BigDecimal newPrice) {this.price = newPrice;}

    public void addImage(String image) {this.image = image;}

    public String getImage() {return image;}

}
