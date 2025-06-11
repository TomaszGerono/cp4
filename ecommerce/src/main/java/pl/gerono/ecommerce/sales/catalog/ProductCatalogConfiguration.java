package pl.gerono.ecommerce.sales.catalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ProductCatalogConfiguration {
    @Bean
    ProductCatalog createProductCatalog(ProductRepository productRepository) {
        var productCatalog = new ProductCatalog(productRepository);


        productCatalog.addProduct("Nice One 1", "nice product");
        productCatalog.addProduct("Nice One 2", "nice product");
        productCatalog.addProduct("Nice One 3", "nice product");

        return productCatalog;
    }


    @Bean
    ProductRepository createMyProductRepository(JdbcTemplate jdbcTemplate) {
        return new DatabaseProductRepository(jdbcTemplate);
    }
}
