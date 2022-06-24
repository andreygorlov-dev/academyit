package exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Исправить код файла GIBDD таким образом чтобы ГИБДД не выписывала штраф в
 * случае если скорость движения ТС ниже 80 км/ч
 */
public class Task4 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        //Изменена максимальная разрешённая скорость
        Integer maxAccessSpeed = 80;//макс. разрешенная скорость движения
        Integer speedGrade = 20;//коэффициент штрафа, каждые 20 км/ч штраф увелич. на 500р
        Integer fineGrade = 500;
        Integer dangerSpeed = 180;

        System.out.println("введите скорость");
        Integer speed = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());

        if (speed > dangerSpeed) {
            System.out.println("Немедленно остановитесь!");
        } else if (speed > maxAccessSpeed) {
            Integer overSpeed = speed - maxAccessSpeed;//скорость превышения
            Integer k = overSpeed / speedGrade;//коэффициент превышения скорости
            Integer fine = (k == 0 ? 1 : k) * fineGrade;//величина штрафа
            System.out.println("Штраф составляет " + fine);
        } else {
            System.out.println("Доброго пути!");
        }
    }
}
