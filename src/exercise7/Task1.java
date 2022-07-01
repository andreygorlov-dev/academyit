package exercise7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ввести массив целых чисел в консоль. При попытке
 * ввести значение нецелого типа автоматически
 * генерировать исключение. Введенный массив вывести
 * в обратном порядке
 */
public class Task1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            int[] arr = new int[10];

            for (int i = 0; i < arr.length; i++) {
                System.out.println("Введи число #" + i);
                if (!scanner.hasNextInt()) {
                    throw new Exception("Вы ввели не целое число");
                }
                arr[i] = scanner.nextInt();
            }
            printArrayReverse(arr);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printArrayReverse(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + "\t");
        }
    }

}
