package exercise9;

import java.util.stream.IntStream;

/**
 * Изменить алгоритм, используя Stream API
 * int[] arr = {50, 60, 70, 80, 90, 100, 110, 120};
 * int count = 0;
 * for (int x : arr) {
 *  if (x >= 80) continue;
 *  x += 10;
 *  count++;
 *  if (count > 2) break;
 *  System.out.print(x);
 * }
 */
public class Main {

    public static void main(String[] args) {
        IntStream.of(50, 60, 70, 80, 90, 100, 110, 120)
                .filter(x -> x < 80)
                .map(x -> x + 10)
                .limit(2)
                .forEach(System.out::print);
    }

}
