package lesson2;

/**
 * Создайте рандомное число от 1 до 5
 * необходимо вывести все цифры от 1 до рандомного числа, используя оператор switch
 */
public class Task1 {

    public static void main(String[] args) {
        int a = (int) (Math.random() * 5 + 1);

        switch (a) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("1, 2");
                break;
            case 3:
                System.out.println("1, 2, 3");
                break;
            case 4:
                System.out.println("1, 2, 3, 4");
                break;
            case 5:
                System.out.println("1, 2, 3, 4, 5");
                break;
            default:
                break;
        }
    }

}
