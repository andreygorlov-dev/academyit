package exercise10;

/**
 * Дано слово из четного числа букв. Поменять местами его половины. Вывести
 * полученную строку в верхнем регистре.
 */
public class Task2 {

    public static void main(String[] args) {
        final String str = "Java";

        System.out.println(str.toUpperCase().substring(str.length() / 2) + str.toUpperCase().substring(0, str.length() / 2));
    }

}
