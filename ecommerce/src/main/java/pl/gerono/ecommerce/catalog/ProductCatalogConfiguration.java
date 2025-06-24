package pl.gerono.ecommerce.catalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

@Configuration
public class ProductCatalogConfiguration {
    @Bean
    ProductCatalog createProductCatalog(ProductStorage productRepository) {
        var productCatalog = new ProductCatalog(productRepository);

        productCatalog.addProduct("Lorem ipsum dolor sit amet", "consectetur adipiscing elit");
        productCatalog.addProduct("sed do eiusmod tempor incididunt", "ut labore et dolore magna aliqua");
        productCatalog.addProduct("Ut enim ad minim veniam", "quis nostrud exercitation ullamco laboris");

        return productCatalog;
    }


    @Bean
    ProductStorage createMyProductRepository(JdbcTemplate jdbcTemplate) {
        return new DatabaseProductRepository(jdbcTemplate);
    }
}
