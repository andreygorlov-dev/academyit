package lesson6.office;

public class Programmer extends Office {

    public Programmer() {
        setPosition("Программист");
        calcSalary();
    }

    @Override
    public void setRate() {
        rate = 4;
    }
}
