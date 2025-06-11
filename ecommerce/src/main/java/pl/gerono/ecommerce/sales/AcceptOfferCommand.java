package pl.gerono.ecommerce.sales;

public class AcceptOfferCommand {
    String fname;
    String lname;
    String email;


    public AcceptOfferCommand setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public AcceptOfferCommand setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public AcceptOfferCommand setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFname() {return this.fname;}

    public String getLname() {return this.lname;}

    public String getEmail() {return email;}

}
