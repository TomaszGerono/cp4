package pl.gerono.ecommerce.sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.gerono.ecommerce.sales.catalog.ArrayListProductRepository;
import pl.gerono.ecommerce.sales.catalog.ProductCatalog;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class SalesTest {

    ProductCatalog catalog;

    @BeforeEach
    void setup() {
        catalog = new ProductCatalog(new ArrayListProductRepository());
    }

    @Test
    void itShowsEmptyOffer() {
        SalesFacade sales = thereIsSalesModuleUnderTest();
        String customerId = thereIsCustomer("Kuba");

        Offer offer = sales.getCurrentOffer(customerId);

        assertEquals(BigDecimal.ZERO, offer.getTotal());
    }

    @Test
    void itAllowsToCollectProducts() {
        //Arrange
        SalesFacade sales = thereIsSalesModuleUnderTest();
        String customerId = thereIsCustomer("Kuba");
        String procuctId = thereIsProduct("Produxt X", BigDecimal.valueOf(10));

        //Act
        sales.addToCart(customerId, procuctId);
        Offer offer = sales.getCurrentOffer(customerId);

        assertEquals(BigDecimal.valueOf(10), offer.getTotal());
    }

    @Test
    void itAllowsToCollectProductsByCustomersSeparately() {
        //Arrange
        SalesFacade sales = thereIsSalesModuleUnderTest();
        String customer1 = thereIsCustomer("Kuba");
        String customer2 = thereIsCustomer("Michal");
        String procuctId = thereIsProduct("Produxt X", BigDecimal.valueOf(10));

        //Act
        sales.addToCart(customer1, procuctId);
        sales.addToCart(customer2, procuctId);
        sales.addToCart(customer2, procuctId);

        Offer offer1 = sales.getCurrentOffer(customer1);
        Offer offer2 = sales.getCurrentOffer(customer1);

        assertEquals(BigDecimal.valueOf(10), offer1.getTotal());
        assertEquals(BigDecimal.valueOf(20), offer2.getTotal());
    }

    @Test
    void offerAcceptance() {
        //Arrange
        SalesFacade sales = thereIsSalesModuleUnderTest();
        String customerId = thereIsCustomer("Kuba");
        String procuctId = thereIsProduct("Produxt X", BigDecimal.valueOf(10));

        //Act
        sales.addToCart(customerId, procuctId);
        Offer offer = sales.getCurrentOffer(customerId);

        ReservationDetails details = sales.acceptOffer(
                new AcceptOfferCommand()
                        .setFname("Kuba")
                        .setLname("Kanclerz")
                        .setEmail("kuba.kanclerz@example.com")
        );
    }

    private String thereIsProduct(String name, BigDecimal price) {
        var id = catalog.createProduct(name, "desc");
        catalog.changePrice(id, price);

        return id;
    }

    private String thereIsCustomer(String customerName) {
        return String.format("customer__%s", customerName);
    }

    private SalesFacade thereIsSalesModuleUnderTest() {
        return new SalesFacade();
    }
}
