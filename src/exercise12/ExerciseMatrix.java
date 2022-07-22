package exercise12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Доработать задание с матрицей, использовать один объект String Builder для
 * отображения двух матриц – исходной и возведенной в степень равную номеру
 * строки. Дозаписать в файл полученную матрицу.
 */
public class ExerciseMatrix {
    public static void main(String[] args) throws Exception {
        File file = new File("D:/test.txt");
        if (!file.exists()) {
            FileOutputStream openFile = new FileOutputStream(file, false);
        }
        FileWriter writer = new FileWriter(file, true);
        var builder = new StringBuilder();
        var sc = new Scanner(file);// сканируем файл
        var i = 1;
        while (sc.hasNext()) {      //считываем пока есть строки
            String str = sc.nextLine();
            System.out.println(str);
            String[] mas = str.split(" ");
            for (var item : mas) {
                writer.write((int) Math.pow(Integer.parseInt(item), i) + "\t");
                builder.append((int) Math.pow(Integer.parseInt(item), i)).append("\t");
            }
            writer.write("\n");
            builder.append("\n");
            i++;
        }
        writer.flush();
        sc.close();
        System.out.println(builder);
    }
}
