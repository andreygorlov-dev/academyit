package exercise14;

public class RedRenaultLoganCarBuild implements CarBuilder {

    private Engine engine;
    private CarBody carBody;

    private RedRenaultLoganCarBuild() {
        super();
        System.out.println("Начало сборки машины");
    }

    public static RedRenaultLoganCarBuild newInstance() {
        return new RedRenaultLoganCarBuild();
    }

    @Override
    public CarBuilder fixEngine() {
        engine = new Engine(10);
        return this;
    }

    @Override
    public CarBuilder fixBody() {
        carBody = new CarBody("Red");
        return this;
    }

    @Override
    public Car build() {
        return new Car("Renault Logan", engine, carBody);
    }
}
