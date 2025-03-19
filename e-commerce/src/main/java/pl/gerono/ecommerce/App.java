package pl.gerono.ecommerce;

public class App {
    public static void main(String[] args) {
//        var name = "Tomasz";
//        System.out.println("Hello, " + name + "!");

        int a = 2;
        int b = 4;
        int result = a - b;

        if (result != 6) {
            throw new IllegalStateException("Assertion error");
        }
    }
}
