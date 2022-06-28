package exercise5.task2;

public class Order {

    private Factory factory;
    private int count;
    private String[] models;
    private int sum = 0;
    private Car[] cars;

    public Order(Factory factory, int count, String[] models) {
        this.factory = factory;
        this.count = count;
        this.models = models;
        this.cars = new Car[count];
        this.start();
    }

    public void showInfoOrder() {
        for (Car car : cars) {
            if (car != null) {
                System.out.println("Автомобиль " + car.getTitle() + " стоит " + car.getPrice());
            }
        }
        showCountModels();
        System.out.println("Сумма заказа " + this.sum);
    }

    private void showCountModels() {
        for (String model : models) {
            int count = 0;
            for (Car car : cars) {
                if (car != null && model.equals(car.getTitle())) {
                    count++;
                }
            }
            System.out.println("Машин марки " + model + " произведено " + count + " штук");
        }

    }

    private void start() {
        for (int i = 0; i < count; i++) {
            this.cars[i] = factory.createCar(models[(int) (Math.random() * models.length)]);
            if (this.cars[i] != null) {
                this.sum += this.cars[i].getPrice();
            }
        }
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String[] getModels() {
        return models;
    }

    public void setModels(String[] models) {
        this.models = models;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }
}
