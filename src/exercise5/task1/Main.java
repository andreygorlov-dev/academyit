package exercise5.task1;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Product product = null;

        switch ((int) (Math.random() * 3)) {
            case 0:
                product = new Car(1000000f, 1000f, "Рено логан", 0);
                break;
            case 1:
                product = new Cake(300f, 0.5f, "Неженка", 1, 10, 40);
                break;
            case 2:
                product = new Milk(300f, 0.5f, "Рамоз", new Date());
                break;
            default:
                break;
        }

        System.out.println(product.getInfo());

    }

}
