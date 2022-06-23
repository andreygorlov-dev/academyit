package lesson2;

public class Table {
    public static void main(String[] args) {
        int str = 1;
        while (str <= 100) {
            int col = 1;
            while (col <= 10) {
                System.out.print(col * str + "\t");
                col++;
            }
            System.out.println();
            str++;
        }
    }
}
