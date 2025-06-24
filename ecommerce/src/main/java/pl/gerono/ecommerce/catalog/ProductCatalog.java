package pl.gerono.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {

    private final ProductStorage productStorage;
    private String image;

    public ProductCatalog(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public List<Product> allProducts() {
        return productStorage.allProducts();
    }

    public String addProduct(String name, String description) {
        UUID id = UUID.randomUUID();
        Product newProduct = new Product(id, name, description);
        productStorage.save(newProduct);

        return newProduct.getId();
    }

//    public String addProduct(Product product) {
//        String id = product.getId();
//        String name = product.getName();
//        String description = product.getDescription();
//
//        return id;
//    }

    public Product getProductBy(String id) {
        return productStorage.loadProductById(id);
    }

    public void changePrice(String id, BigDecimal newPrice) {
        Product loaded = productStorage.loadProductById(id);
        loaded.changePrice(newPrice);
    }
}
