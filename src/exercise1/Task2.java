package exercise1;

/**
 * Даны три числа. Увеличьте первое число в два раза, второе число уменьшите
 * на 3, третье число возведите в квадрат и затем найдите сумму новых трех чисел.
 */
public class Task2 {

    public static void main(String[] args) {

        int firstNumber = 10;
        int secondNumber = 20;
        int thirdNumber = 3;

        firstNumber *= 2;
        secondNumber -= 3;
        thirdNumber = (int) Math.pow(thirdNumber, 2);

        System.out.println(firstNumber + secondNumber + thirdNumber);

    }

}
