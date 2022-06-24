package exercise4;

/**
 * Написать программу, которая вычисляет сумму двумерного массива по строкам*
 */
public class Task1 {

    public static void main(String[] args) {
        // Один столбец выделяем под сумму строки
        int[][] matrix = new int[5][6];

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;

            for (int j = 0; j < matrix[i].length - 1; j++) {
                matrix[i][j] = i * j;
                sum += matrix[i][j];
                System.out.print(matrix[i][j] + "\t");
            }

            matrix[i][matrix[i].length - 1] = sum;
            System.out.println(matrix[i][matrix[i].length - 1]);
        }
    }

}
