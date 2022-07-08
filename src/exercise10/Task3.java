package exercise10;

/**
 * Дано предложение. Необходимо проверить его на наличие ошибок в
 * буквосочетании «жи» и «ши» и исправить их
 */
public class Task3 {

    public static void main(String[] args) {
        String str = "животное малышы машина коржЫ";
        str = str.toLowerCase();
        if (str.contains("жы") || str.contains("шы")) {
            System.out.println("Ошибки есть!!!");
            System.out.println("Исправленная строка:");
            System.out.println(str.replace("жы", "жи").replace("шы", "ши"));
        } else {
            System.out.println("Ошибок нет");
        }
    }

}
