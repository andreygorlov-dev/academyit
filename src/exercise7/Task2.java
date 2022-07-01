package exercise7;

/**
 * Создайте два числовых массива и разделите каждый
 * элемент первого массива на каждый элемент второго
 * массива. Обработайте исключение деления на 0
 */
public class Task2 {

    public static void main(String[] args) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];

        fillArray(arr1);
        fillArray(arr2);

        try {
            int i = 1;
            for (int item1 : arr1) {
                for (int item2 :arr2) {
                    System.out.print(i + ") " + item1 + " / " + item2 + " = ");
                    int result = item1 / item2;
                    System.out.println(result);
                    i++;
                }
            }
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
    }

}
