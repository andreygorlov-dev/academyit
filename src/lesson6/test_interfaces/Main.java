package lesson6.test_interfaces;

public class Main {

    public static void main(String[] args) {

        IMessenger[] messengers = {
                new Viber("Информация о Viber"),
                new Telegram("Информация о Telegram")
        };

        for (IMessenger messenger : messengers) {
            messenger.getMessage();
            messenger.about(messenger.getTitle());
        }
    }

}
