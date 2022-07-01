package exercise6;

public class ProductByWeight extends Product {

    private int weightInKg = 0;

    public ProductByWeight(String title, int weightInKg) {
        super(title);
        this.weightInKg = weightInKg;
    }

    public ProductByWeight(String title) {
        super(title);
    }

    public int getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(int weightInKg) {
        this.weightInKg = weightInKg;
    }

    @Override
    public float calculatedPrice() {
        return price * weightInKg;
    }

}
