package exercise5.task1;

public class Car extends Product{

    private int mileage;

    public Car(float price, float weight, String name, int mileage) {
        super(price, weight, name);
        this.mileage = mileage;
        this.title = "Автомобиль";
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "; пробег: " + mileage;
    }
}
