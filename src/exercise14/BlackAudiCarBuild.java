package exercise14;

public class BlackAudiCarBuild implements CarBuilder {

    private Engine engine;
    private CarBody carBody;

    private BlackAudiCarBuild() {
        super();
        System.out.println("Начало сборки машины");
    }

    public static BlackAudiCarBuild newInstance() {
        return new BlackAudiCarBuild();
    }

    @Override
    public CarBuilder fixEngine() {
        engine = new Engine(12);
        return this;
    }

    @Override
    public CarBuilder fixBody() {
        carBody = new CarBody("Black");
        return this;
    }

    @Override
    public Car build() {
        return new Car("Audi", engine, carBody);
    }
}
