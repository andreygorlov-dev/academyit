package exercise6;

public class DigitalProduct extends Product {

    public DigitalProduct(String title) {
        super(title);
    }

    @Override
    public float calculatedPrice() {
        return price / 2;
    }

}
