package pl.gerono.ecommerce.payu;

public class PayUConfiguration {

    String posId;
    String md5;
    String clientId;
    String clientSecret;

    boolean sandbox;

    public PayUConfiguration(String posId, String md5, String clientId, String clientSecret, boolean sandbox) {
        this.posId = posId;
        this.md5 = md5;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.sandbox = sandbox;
    }

//    public static PayUConfigurationbyEnvVariables() {
//        return null;
//    }

//    public static sandbox PayUConfigurationSandbox() {
//        return new PayUConfiguration;
//    }
}
