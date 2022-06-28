package exercise5.task1;

public class Cake extends Product {

    private int proteins;
    private int fats;
    private int carbohydrates;

    public Cake(float price, float weight, String name, int proteins, int fats, int carbohydrates) {
        super(price, weight, name);
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.title = "Торт";
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "; белков: " + proteins + "; жиров: " + fats + "; углеводов: " + carbohydrates;
    }
}
