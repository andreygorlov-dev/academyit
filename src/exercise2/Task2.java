package exercise2;

import java.util.Scanner;

/**
 * Сделать проверку ученика на знание таблицы умножения. Задается 5 примеров, где
 * спрашиваем ответ на вопрос по умножению двух случайных чисел. Если ответ не
 * верный, то увеличиваем счетчик ошибок на 1. После примеров выставляем
 * зачет/незачет
 */
public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        for (int i = 1; i <= 5; i++) {
            int firstNumber = (int) (Math.random() * 10 + 1);
            int secondNumber = (int) (Math.random() * 10 + 1);
            int answer = 0;
            while (true) {
                System.out.print(i + ") Сколько будет: " + firstNumber + " * " + secondNumber + " = ");
                if (scanner.hasNextInt()) {
                    answer = scanner.nextInt();
                    break;
                }
                System.out.println("Введено не число, ещё раз!");
                scanner.nextLine();
            }
            if (firstNumber * secondNumber == answer) {
                System.out.println("Ответ верный");
            } else {
                System.out.println("Ответ не верный");
                count++;
            }
        }

        if (count >= 2) {
            System.out.println("Незачет");
        } else {
            System.out.println("Зачет");
        }

        scanner.close();

    }

}
