package exercise2;

/**
 * Написать программу сравнения двух случайных чисел. В результате должна
 * содержаться информация – насколько одно число больше другого. Используйте
 * модуль числа
 */
public class Task6 {

    public static void main(String[] args) {
        int a = (int) (Math.random() * 1000 + 100);
        int b = (int) (Math.random() * 1000 + 100);

        if (a == b) {
            System.out.println("Число a = " + a + " равно числу b = " + b);
        } else {
            System.out.println("Число a = " + a + (a > b ? " больше " : " меньше ") +  "числа b = " + b + " на " + Math.abs(a - b));
        }
    }


}
