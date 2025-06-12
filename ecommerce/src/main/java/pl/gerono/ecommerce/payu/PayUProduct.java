package pl.gerono.ecommerce.payu;

public class PayUProduct {
    String name;
    Integer unitPrice;
    Integer quantity;

    public String getName() {
        return name;
    }

    public PayUProduct setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public PayUProduct setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public PayUProduct setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    //     "name": "Wireless Mouse for Laptop",
//            "unitPrice": "15000",
//            "quantity": "1"
}
