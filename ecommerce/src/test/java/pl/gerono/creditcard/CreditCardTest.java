package pl.gerono.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {

    @Test
    void cardIsIdentifiedWithNumber() {
        // Arrange   // Given   // Input
        var number = "1234-5678";
        // Act      // When     // Action
        var card = new CreditCard(number);
        // Assert   // Then     // Output
        assertEquals(
                "1234-5678",
                card.getNumber()
        );
    }


    @Test
    void itAllowsToAssignInitialCredit() {
        // Arrange
        var card = new CreditCard("1234-5678");
        // Act
        card.assignCredit(BigDecimal.valueOf(1500));
        // Assert
        assertEquals(
                BigDecimal.valueOf(1500),
                card.getBalance()
        );
    }

    @Test
    void limitCantBeLowerThanThreshold() {
        var card = new CreditCard("1234-5678");
        try {
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Exception should be thrown");
        }
        catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }
    }


    @Test
    void limitCantBeLowerThanThresholdV2() {
        var card = new CreditCard("1234-5678");
        assertThrows(
                 CreditBelowThresholdException.class,
                 () -> card.assignCredit(BigDecimal.valueOf(99))
         );

    }

    @Test
    void limitCantBeLowerThanThresholdV3() {
        var card = new CreditCard("1234-5678");
        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(99))
        );

        assertDoesNotThrow(
                () -> card.assignCredit(BigDecimal.valueOf(100))
        );
    }

    @Test
    void creditCantBeAssignedTwice() {
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));
        assertThrows(
                CreditCantBeAssignedTwiceException.class,
                () -> card.assignCredit(BigDecimal.valueOf(1500))
        );
    }


    @Test
    void itAllowsToWithdrawSomeMoneyV1() {
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1500));

        card.pay(BigDecimal.valueOf(100));

        assertEquals(
                BigDecimal.valueOf(1400),
                card.getBalance()
        );
    }


    @Test
    void itAllowsToWithdrawSomeMoneyV2() {
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1500));

        assertThrows(
                NotEnoughMoneyException.class,
                () -> card.pay(BigDecimal.valueOf(1600))
        );
    }



    @Test
    void itAllowsToWithdrawSomeMoneyV3() {
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));
        card.pay(BigDecimal.valueOf(100));
        card.pay(BigDecimal.valueOf(100));
        card.pay(BigDecimal.valueOf(100));
        assertEquals(
                BigDecimal.valueOf(700),
                card.getBalance()
        );
    }


    @Test
    void cantWithdrawWhenNotEnoughMoney() {
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));
        card.pay(BigDecimal.valueOf(100));
        assertThrows(
                NotEnoughMoneyException.class,
                () -> card.pay(BigDecimal.valueOf(950))
        );
    }

    @Test
    void canWithdrawWhenSpendingTotalCredit() {
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));
        assertDoesNotThrow(
                () -> card.pay(BigDecimal.valueOf(1000))
        );
    }
}