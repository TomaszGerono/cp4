package pl.gerono.ecommerce.sales.reservation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.gerono.ecommerce.sales.SalesFacade;

@Configuration
public class SalesConfiguration {
    @Bean
    SalesFacade createSales() {
        return new SalesFacade();
    }
}