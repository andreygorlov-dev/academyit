package chat;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ClientApp {

    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите ваше имя: ");
            User user = new User(scanner.nextLine(), User.getRandomColor());
            System.out.println("Введите адрес сервера: ");
            String address = scanner.nextLine();
            try (Socket socket = new Socket(address, 8080);
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
                SocketThread socketThread = new SocketThread(socket);
                socketThread.start();
                System.out.println("Подключение прошло успешно! Можете общаться!");
                while (true) {
                    Message message = new Message(user, scanner.nextLine(), new Date());
                    objectOutputStream.writeObject(message);
                    objectOutputStream.flush();
                }
            }
        }
    }

    private static class SocketThread extends Thread {

        private final Socket socket;

        public SocketThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {
                ArrayList<Message> messageArrayList = (ArrayList<Message>) objectInputStream.readObject();

                for (Message message : messageArrayList) {
                    message.printMessage();
                }

                while (true) {
                    Message message = (Message) objectInputStream.readObject();
                    message.printMessage();
                }

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
