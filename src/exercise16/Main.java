package exercise16;

import javax.xml.xpath.XPathExpressionException;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 1) Использовать в примере из урока PreparedStatement. Создайте метод, который
 * выводит информацию об автомобиле по ее названию
 * 2) Оптимизировать класс ORMSecond и протестировать его методы при
 * обращении к базе данных
 * 3) Сделать XML с настройками конфигурации, которые используются при
 * коннекте к базе данных
 */
public class Main {
    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException, SQLException, ClassNotFoundException {
        Config config = new Config("D:\\Programm\\Java\\academyit\\src\\exercise16\\connection.xml");
        config.showData();

        Map<String, String> values = new HashMap<>();

        values.put("title", "Рено");
        values.put("price", "10");
        values.put("description", "Новая");

        if (OrmSecond.insert("CARS", values)) {
            System.out.println("Запись добавлена");
        } else {
            System.out.println("Запись не добавлена");
        }

        if (OrmSecond.update("CARS", values, "WHERE title = 'Москвич'")) {
            System.out.println("Запись обновлена");
        } else {
            System.out.println("Запись не обновлена");
        }

        if (OrmSecond.delete("CARS", 1)) {
            System.out.println("Запись удалена");
        } else {
            System.out.println("Запись не удалена");
        }

        OrmSecond.showCarByName("Рено");
    }
}
