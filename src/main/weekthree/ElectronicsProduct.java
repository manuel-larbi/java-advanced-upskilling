package weekthree;

public final class ElectronicsProduct extends Product {
    private final String brand;
    public ElectronicsProduct(String name, double price, String category, String brand) {
        super(name, price, category);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
