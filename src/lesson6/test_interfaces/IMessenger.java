package lesson6.test_interfaces;

public interface IMessenger {

    void getMessage();
    void sendMessage();

    String getTitle();

    default void about(String info) {
        System.out.println(info);
    }

}
