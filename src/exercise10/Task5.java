package exercise10;

import javax.swing.*;
import java.awt.*;

/**
 * Сделать окно, в котором вводим два числа. Есть 4 кнопки – каждая кнопка
 * отвечает за действие – сложение, вычитание, умножение или деление.
 * Результат операции вывести в элементе Jlabel. Оформить окно и компоненты
 * окна
 */
public class Task5 {

    public static void main(String[] args) {
        createForm();
    }

    private static void createForm() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = jFrame.getContentPane();
        JEditorPane jFirstEditorPanel = new JEditorPane();
        JEditorPane jSecondEditorPanel = new JEditorPane();
        JButton jButtonPlus = new JButton("+");
        JButton jButtonMinus = new JButton("-");
        JButton jButtonDiv = new JButton("/");
        JButton jButtonMult = new JButton("*");
        JLabel jResultLabel = new JLabel();
        jResultLabel.setSize(100, 30);
        container.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));
        container.add(jFirstEditorPanel);
        container.add(jSecondEditorPanel);

        container.add(jButtonPlus);
        container.add(jButtonMinus);
        container.add(jButtonDiv);
        container.add(jButtonMult);
        container.add(jResultLabel);
        jFrame.pack();
        jFrame.setSize(600, 100);
        jButtonPlus.addActionListener(e -> {
            try {
                jResultLabel.setText(String.valueOf(Float.parseFloat(jFirstEditorPanel.getText()) + Float.parseFloat(jSecondEditorPanel.getText())));
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(jFrame, "Неверное число", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
        jButtonMinus.addActionListener(e -> {
            try {
                jResultLabel.setText(String.valueOf(Float.parseFloat(jFirstEditorPanel.getText()) - Float.parseFloat(jSecondEditorPanel.getText())));
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(jFrame, "Неверное число", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
        jButtonDiv.addActionListener(e -> {
            try {
                jResultLabel.setText(String.valueOf(Float.parseFloat(jFirstEditorPanel.getText()) / Float.parseFloat(jSecondEditorPanel.getText())));
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(jFrame, "Неверное число", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
        jButtonMult.addActionListener(e -> {
            try {
                jResultLabel.setText(String.valueOf(Float.parseFloat(jFirstEditorPanel.getText()) * Float.parseFloat(jSecondEditorPanel.getText())));
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(jFrame, "Неверное число", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });

    }

}
