package exercise14;

public class Car {

    private boolean isEngine = false;
    private String title;

    private Engine engine;
    private CarBody carBody;

    public Car(String title, Engine engine, CarBody carBody) {
        this.title = title;
        this.engine = engine;
        this.carBody = carBody;
    }

    public boolean isEngine() {
        return isEngine;
    }

    public void startEngine() {
        if (!isEngine) {
            isEngine = true;
            System.out.println("Двигатель запущен");
        }
    }

    public void turnOffEngine() {
        if (isEngine) {
            isEngine = false;
            System.out.println("Двигатель заглушен");
        }
    }

    public void showData() {
        System.out.println(title + " объём двигателя " + engine.getValue() + " цвет " + carBody.getColor());
    }

}
