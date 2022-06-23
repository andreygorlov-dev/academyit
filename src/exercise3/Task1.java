package exercise3;

/**
 * Отобразить шахматную доску
 */
public class Task1 {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        for (int i = 8; i > 0; i--) {
            for (char ch : chars) {
                System.out.print(String.valueOf(ch) + i + " ");
            }
            System.out.println();
        }

    }

}
