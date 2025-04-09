package pl.gerono.productcatalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {

    ProductRepository productRepository;

    public ProductCatalog(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> allProducts() {
        return productRepository.allProducts();
    }

    public String createProduct(String name, String description) {
        UUID productId = UUID.randomUUID();

        var newProduct = new Product(
                productId,
                name,
                description
        );  // DOMAIN // BUSINESS

        productRepository.save(newProduct); // TECH

        return newProduct.getId();
    }



    public Product loadProductById(String productId) {
        return productRepository.loadProductById(productId);
    }

    public void changePrice(String productId, BigDecimal newPrice) throws InvalidProductPriceException {
        if (newPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidProductPriceException();
        }  // DOMAIN

        var loadedProduct = productRepository.loadProductById(productId);
        loadedProduct.changePrice(newPrice);
    }

    public void changeImage(String productId, String url) {

    }


}
