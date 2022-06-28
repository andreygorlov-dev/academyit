package lesson6.office;

public class Economist extends Office{

    public Economist() {
        setPosition("Экономист");
        calcSalary();
    }

    @Override
    public void setRate() {
        rate = 2;
    }

}
