package exercise8;

import java.util.Scanner;

/**
 * Создайте офис по созданию номеров автомобилей. У номера авто есть свойства
 * – номер, серия, регион и владелец. Серию номер можно представить в виде
 * трех букв(например, А111АА199, в этом примере, серия это ААА, номер это 111,
 * регион 199). Заполнить коллекцию объектов и сделать поиск владельца авто по
 * номеру авто. Серию номера вводит юзер либо вручную либо генерирует
 * автоматически
 */
public class Main {

    public static void main(String[] args) {
        // Список фио для рандомного выбора
        String[] owners = {
                "Иванов Иван Иванович",
                "Петров Пётр Петрович",
                "Козлов Иван Петрович",
                "Маликова Ирина Юрьевна"
        };

        Office office = new Office();

        int i = 0;
        while (i < 10) {
             //Создаём машину из случайного номера, случайного региона и генерим серию из 3 случайных букв
            CarNumber carNumber = new CarNumber((int) (Math.random() * 900 + 100),
                    (int) (Math.random() * 990 + 10),
                    String.valueOf(CarNumber.chars.charAt((int) (Math.random() * 27 + 1))) +
                            String.valueOf(CarNumber.chars.charAt((int) (Math.random() * 27 + 1))) +
                            String.valueOf(CarNumber.chars.charAt((int) (Math.random() * 27 + 1))),
                    owners[(int) (Math.random() * 4)]);
            if (office.addCarNumber(carNumber)) {
                i++;
            }
        }

        office.showInfo();
        System.out.println();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите номер машины по номеру, пример формата \"x000xx111\": ");

            String findCarNum = scanner.next();
            System.out.println(office.findOwner(findCarNum));
        }
    }

}
