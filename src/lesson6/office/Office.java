package lesson6.office;

public abstract class Office {

    private final float BASE_SALARY = 30000f;
    private String position;
    private float salary;
    protected int rate;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public abstract void setRate();

    protected void calcSalary() {
        setRate();
        salary = rate * BASE_SALARY;
        System.out.println("Сотрудник с должностью " + position + " имеет оклад " + salary);
    }

}
