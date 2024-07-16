package weekthree.lab1;

public final class ClothingProduct extends Product {
    private final String size;
    protected ClothingProduct(String name, double price, String category, String size) {
        super(name, price, category);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
