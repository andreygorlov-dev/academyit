package chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServerApp {

    private static List<Message> messageList = new ArrayList<>();
    private static List<Socket> socketList = new ArrayList<>();
    private static List<ServerThread> serverThreadList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server start: " + serverSocket.getLocalSocketAddress().toString());
            while (true) {
                socketList.add(serverSocket.accept());
                serverThreadList.add(new ServerThread(socketList.get(socketList.size() - 1)));
                serverThreadList.get(serverThreadList.size() - 1).start();
            }
        }
    }

    private static class ServerThread extends Thread {

        private final Socket socket;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            //Отправляет все сообщения при подключении нового клиента
            try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
                outputStream.writeObject(messageList);
                outputStream.flush();


                //Обрабатываем полученные сообщения
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    while (true) {
                        String line = bufferedReader.readLine();
                        Message message = new Message(new User(socket.getInetAddress().getHostAddress(), "red"), line, new Date());
                        messageList.add(message);
                        sendMessageAllClient(message);
                        System.out.println(messageList.get(messageList.size() - 1).toString());
                    }
                }

            } catch (IOException e) {
                System.out.println("Клиент отключился");
            }

        }

        private void sendMessageAllClient(Message message) throws IOException {
            for (Socket socketItem : socketList) {
                if (socketItem.isConnected() && !socketItem.equals(socket)) {
                    try (ObjectOutputStream outputStream = new ObjectOutputStream(socketItem.getOutputStream())) {
                        outputStream.writeObject(message);
                        outputStream.flush();
                    }
                }
            }

        }

    }

}
