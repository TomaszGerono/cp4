package pl.gerono.ecommerce.payu;

public class Buyer {
    String firstName;
    String lastName;
    String phoneNumber;
    String emailAddress;
    String language;

    public String getFirstName() {
        return firstName;
    }

    public Buyer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Buyer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Buyer setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Buyer setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Buyer setLanguage(String language) {
        this.language = language;
        return this;
    }
}
