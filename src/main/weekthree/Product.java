package weekthree;

public sealed class Product permits ElectronicsProduct, ClothingProduct {
    private final String name;
    private final double price;
    private final String category;

    protected Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
