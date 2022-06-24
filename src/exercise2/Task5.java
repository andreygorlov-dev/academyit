package exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Исправить код так чтобы штраф был уменьшен в 2 раза если срок оплаты менее 30
 * дней
 */
public class Task5 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Integer maxAccessSpeed = 30;//макс. разрешенная скорость движения
        Integer speedGrade = 20;//коэффициент штрафа, каждые 20 км/ч штраф увелич. на 500р
        Integer fineGrade = 500;
        Integer dangerSpeed = 180;

        System.out.println("введите скорость");
        Integer speed = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());

        if(speed>dangerSpeed) {
            System.out.println("Немедленно остановитесь!");
        } else if(speed>maxAccessSpeed) {
            Integer overSpeed = speed - maxAccessSpeed;//скорость превышения
            Integer k = overSpeed/speedGrade;//коэффициент превышения скорости
            Integer fine = (k == 0 ? 1 : k) * fineGrade;//величина штрафа

            System.out.println("Через сколько дней оплачен штраф: ");
            Integer countDay = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
            System.out.println("Ваш штраф составляет " + (countDay < 30 ? fine / 2: fine));
        } else {
            System.out.println("Доброго пути!");
        }
    }

}
