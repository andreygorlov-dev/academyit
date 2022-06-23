package exercise2;

/**
 * Вывести все простые числа от 2 до 100*
 */
public class Task3 {

    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {

            boolean isPrimeNumber = true;

            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0 && j != 1 && j != i) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if (isPrimeNumber) {
                System.out.print(i + " ");
            }

        }
    }

}
