package exercise2;

/**
 * Вывести на экран все целые числа от 100 до 200 кратные 3
 */
public class Task1 {

    public static void main(String[] args) {

        for (int i = 100; i <=200; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }

    }

}
