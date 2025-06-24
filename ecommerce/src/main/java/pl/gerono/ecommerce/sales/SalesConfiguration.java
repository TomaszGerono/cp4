package pl.gerono.ecommerce.sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.gerono.ecommerce.sales.cart.HashMapCartStorage;
import pl.gerono.ecommerce.sales.offering.OfferCalculator;
import pl.gerono.ecommerce.sales.payment.PaymentDetails;
import pl.gerono.ecommerce.sales.payment.RegisterPaymentRequest;
import pl.gerono.ecommerce.sales.reservation.ReservationRepository;

@Configuration
public class SalesConfiguration {
    @Bean
    SalesFacade createSales() {
        return new SalesFacade(
                new HashMapCartStorage(),
                new OfferCalculator(),
                (RegisterPaymentRequest request) -> {
                    return new PaymentDetails("http://payment");
                },
                new ReservationRepository()
        );
    }

}
