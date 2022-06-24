package exercise4;

/**
 * Написать программу, которая вычисляет сумму двумерного массива по столбцам*
 */
public class Task2 {

    public static void main(String[] args) {
        // Одну строку выделяем под сумму столбца
        int[][] matrix = new int[6][5];

        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;

            for (int i = 0; i < matrix.length - 1; i++) {
                matrix[i][j] = i * j;
                sum += matrix[i][j];
            }
            matrix[matrix.length - 1][j] = sum;
        }

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int item : arr) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }

}
