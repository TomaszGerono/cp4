package pl.gerono.ecommerce;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.gerono.productcatalog.ArrayListProductStorage;
import pl.gerono.productcatalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("it works");
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createProductCatalog() {
        ProductCatalog catalog = new ProductCatalog(
                new ArrayListProductStorage()
        );

        catalog.createProduct("nice one 1", "desc");
        catalog.createProduct("nice one 2", "desc");
        catalog.createProduct("nice one 3", "desc");
        catalog.createProduct("nice one 4", "desc");
        catalog.createProduct("nice one 5", "desc");
        catalog.createProduct("nice one 6", "desc");

        return catalog;
    }
}
