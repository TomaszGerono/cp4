package pl.gerono.ecommerce.payu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import pl.gerono.ecommerce.sales.catalog.Product;

import java.util.Arrays;
import java.util.UUID;

public class PayUTest {

    @Test
    void itRegistersPayment() {
        PayU payU = thereIsPayU();

        OrderCreateRequest request = thereIsExampleOrderCreateRequest();
        OrderCreateResponse response = payU.handle(request);

        assertNotNull(response.getRedirectUri());
        assertNotNull(response.orderId());
    }

    private OrderCreateRequest thereIsExampleOrderCreateRequest() {

        var exampleOrderCreateRequest = new OrderCreateRequest();
        exampleOrderCreateRequest
                .setCustomerIP("127.0.0.1")
                .setDescription("Description")
                .setCurrencyCode("PLN")
                .setTotalAmount("21000")
                .setExtOrderId(UUID.randomUUID().toString())
                .setBuyer(new Buyer()
                        .setEmailAddress("john.doe@example.com");
                        .setFirstName("John")
                        .setLastName("Doe")
                )
        .setProducts(Arrays.asList(
                new Product()
        ))
    }

    private PayU thereIsPayU() {

        var cfg = PayUConfiguration.sandbox()

        return new PayU();
    }

}
