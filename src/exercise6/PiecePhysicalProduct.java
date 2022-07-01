package exercise6;

public class PiecePhysicalProduct extends Product {

    public PiecePhysicalProduct(String title) {
        super(title);
    }

    @Override
    public float calculatedPrice() {
        return price;
    }

}
