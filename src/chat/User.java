package chat;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 2894385733379350587L;

    public static final String[] colors = {
            "\u001B[0m",
            "\u001B[31m",
            "\u001B[32m",
            "\u001B[33m",
            "\u001B[34m",
            "\u001B[35m",
            "\u001B[36m",
            "\u001B[37m"
    };

    private final String name;
    private final String color;

    public User(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }
}
