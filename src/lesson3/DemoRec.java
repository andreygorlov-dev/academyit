package lesson3;

/**
 * Рекурсия
 */
public class DemoRec {

    private static void showNumbers(int n) {
        System.out.println(n);
        if (n > 0) {
            showNumbers(n - 1);
        }
    }

    public static void main(String[] args) {
        showNumbers(10);
    }

}
