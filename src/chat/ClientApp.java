package chat;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ClientApp {

    private static String name;
    private static String address;

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите ваше имя: ");
            name = scanner.nextLine();
            System.out.println("Введите адрес сервера: ");
            address = scanner.nextLine();
            try (Socket socket = new Socket("127.0.0.1", 8080);
                 OutputStream outputStream = socket.getOutputStream();
                 PrintWriter printWriter = new PrintWriter(outputStream)) {
                SocketThread socketThread = new SocketThread(socket);
                socketThread.start();
                System.out.println("Подключение прошло успешно! Можете общаться!");
                while (true) {
                    printWriter.println(scanner.nextLine());
                    printWriter.flush();
                }
            }
        }
    }

    private static class SocketThread extends Thread {

        private Socket socket;

        public SocketThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {
                ArrayList<Message> messageArrayList = (ArrayList<Message>) objectInputStream.readObject();

                for (Message message : messageArrayList) {
                    System.out.println(message.toString());
                }


                while (true) {
                    Message message = (Message) objectInputStream.readObject();

                    System.out.println(message.toString());
                }

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
