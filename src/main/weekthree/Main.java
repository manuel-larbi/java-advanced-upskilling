package weekthree;

public class Main {

    public static void main(String[] args) {
        Product product = new Product("Laptop", 999.99, "Electronics");

        String message = switch (product.getCategory()) {
            case "Electronics" -> "This is an electronics product.";
            case "Clothing" -> "This is a clothing product.";
            default -> "Unknown category.";
        };

        System.out.println(message);

    }
}
