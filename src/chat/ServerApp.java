package chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerApp {

    private static final List<Message> messageList = new ArrayList<>();
    private static final List<Socket> socketList = new ArrayList<>();
    private static final List<ServerThread> serverThreadList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                socketList.add(serverSocket.accept());
                serverThreadList.add(new ServerThread(socketList.get(socketList.size() - 1)));
                serverThreadList.get(serverThreadList.size() - 1).start();
            }
        }
    }

    private static class ServerThread extends Thread {

        private final Socket socket;
        private final ObjectOutputStream objectOutputStream;
        private boolean connect;

        public ServerThread(Socket socket) throws IOException {
            this.socket = socket;
            this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            connect = true;
        }

        public ObjectOutputStream getObjectOutputStream() {
            return objectOutputStream;
        }

        public Socket getSocket() {
            return socket;
        }

        public boolean isConnect() {
            return connect;
        }

        @Override
        public void run() {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {
                //Отправляет все сообщения при подключении нового клиента
                objectOutputStream.writeObject(messageList);
                objectOutputStream.flush();
                //Обрабатываем полученные сообщения
                while (true) {
                    Message message = (Message) objectInputStream.readObject();
                    messageList.add(message);
                    sendMessageAllClient(message);
                    message.printMessage();
                }
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("Клиент отключён!");
                connect = false;
            }

        }

        private void sendMessageAllClient(Message message) throws IOException {
            for (ServerThread serverThread : serverThreadList) {
                if (serverThread.isConnect() && !serverThread.getSocket().equals(socket)) {
                    serverThread.getObjectOutputStream().writeObject(message);
                    serverThread.getObjectOutputStream().flush();
                }
            }

        }

    }

}
