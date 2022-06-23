package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DemoScanner {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ваш год рождения");
        if (scanner.hasNextInt()) {
            int year = scanner.nextInt();
            System.out.println("Ваш возраст: " + (2022 - year));
        } else {
            System.out.println("Вы ввели некорректное значение");
        }
        scanner.close();
        /**
         * Альтернатива
         */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ваше имя");
        System.out.println(reader.readLine());
    }

}
