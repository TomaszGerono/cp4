package pl.gerono.ecommerce.payu;

import pl.gerono.ecommerce.sales.catalog.Product;

import java.util.List;

public class OrderCreateRequest {

    String customerIP;

    public String getCustomerIP() {
        return customerIP;
    }

    public OrderCreateRequest setCustomerIP(String customerIP) {
        this.customerIP = customerIP;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderCreateRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public OrderCreateRequest setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public OrderCreateRequest setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public OrderCreateRequest setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public OrderCreateRequest setBuyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }


    public String getExtOrderId() {
        return ExtOrderId;
    }

    public void setExtOrderId(String extOrderId) {
        ExtOrderId = extOrderId;
    }

    String description;
    String currencyCode;
    String totalAmount;
    List<Product> products;
    Buyer buyer;
    String ExtOrderId;

}
