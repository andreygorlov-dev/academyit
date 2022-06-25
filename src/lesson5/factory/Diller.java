package lesson5.factory;

public class Diller {

    private String titleDiller;
    private int ageDiller;

    public Diller(String titleDiller, int ageDiller) {
        this.titleDiller = titleDiller;
        this.ageDiller = ageDiller;
    }

    public String getTitleDiller() {
        return titleDiller;
    }

    public void setTitleDiller(String titleDiller) {
        this.titleDiller = titleDiller;
    }

    public int getAgeDiller() {
        return ageDiller;
    }

    public void setAgeDiller(int ageDiller) {
        this.ageDiller = ageDiller;
    }

    public void createOrder(Factory factory, int count, String[] models) {
        Order order = new Order(factory, count, models);
        //Добавляем скидку
        if (this.ageDiller > 10) {
            System.out.println("Цена без скидки " + order.getSum());
            System.out.println("Дана скидка 10%");
            order.setSum(order.getSum() - (int) (order.getSum() * 0.1));
        }
        order.showInfoOrder();
    }
}
