package exercise10;

import java.util.Scanner;

/**
 * Написать программу, которая проверяет является ли введенное с клавиатуры
 * число – дробным. Использовать строковые методы. Написать программу,
 * которая проверяет является ли введенное с клавиатуры число - целым
 */
public class Task4 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            //Проверка на дробное число
            System.out.println("Введи число: ");
            String first = scanner.nextLine();
            if (first.matches("[-+]?[0-9]+[.,][0-9]+$")) {
                System.out.println("Число дробное");
            } else {
                System.out.println("Число не дробное");
            }
            //Проверка на целое
            System.out.println("Введи число: ");
            String second = scanner.nextLine();
            if (second.matches("[-+]?[0-9]+$")) {
                System.out.println("Число целое");
            } else {
                System.out.println("Число не целое");
            }
        }
    }

}
