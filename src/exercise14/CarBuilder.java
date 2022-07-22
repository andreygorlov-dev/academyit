package exercise14;

public interface CarBuilder {

    CarBuilder fixEngine();

    CarBuilder fixBody();

    Car build();


}
