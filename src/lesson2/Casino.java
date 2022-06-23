package lesson2;

import javax.swing.*;

public class Casino {

    public static void main(String[] args) {
        int money = Integer.parseInt(JOptionPane.showInputDialog("Введите вашу сумму"));

        if (money < 1000) {
            JOptionPane.showMessageDialog(null, "Не достаточно средств для начала игры");
            return;
        }
        int rate = 0;
        while (true) {
            rate = Integer.parseInt(JOptionPane.showInputDialog("Введите вашу ставку"));
            if (rate <= money) {
                JOptionPane.showMessageDialog(null, "Ставка принимается! Игра началась");
                break;
            }
            JOptionPane.showMessageDialog(null, "Не корректная ставка");
        }

        int number = (int) (Math.random() * 9 + 1);

        int count = 3;
        while (count > 0) {
            int answer = Integer.parseInt(JOptionPane.showInputDialog("Попытка № " + (4 - count) + "Введите число"));

            if (number == answer) {
                money += rate;
                JOptionPane.showMessageDialog(null, "Вы угадали, ваша сумма: " + money);
                break;
            }
            count--;
        }

        if (count == 0) {
            money -=rate;
            JOptionPane.showMessageDialog(null, "Вы не угадали, ваша сумма " + money + ", число " + number);
        }


    }

}
