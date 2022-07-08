package exercise10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Даны названия трех городов. Вывести самое длинное и самое короткое.
 */
public class Task1 {

    public static void main(String[] args) {
        List<String> citySet = new ArrayList<>();
        citySet.add("Нью-Йорк");
        citySet.add("Тула");
        citySet.add("Якутия");
        /**
         * Сортируем по возрастанию количества символов
         */
        citySet.sort(Comparator.comparingInt(String::length));
        System.out.println("Самый длинный " + citySet.get(2));
        System.out.println("Самый короткий " + citySet.get(0));
    }

}
