package lesson6.office;

public class Director extends Office {

    public Director() {
        setPosition("Директор");
        calcSalary();
    }

    @Override
    public void setRate() {
        rate = 10;
    }

}
