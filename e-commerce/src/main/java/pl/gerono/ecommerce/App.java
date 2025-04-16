package pl.gerono.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.gerono.ecommerce.catalog.ArrayListProductStorage;
import pl.gerono.ecommerce.catalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main(String[] args) {SpringApplication.run(App.class, args);}

}