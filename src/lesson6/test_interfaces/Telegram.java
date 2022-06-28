package lesson6.test_interfaces;

public class Telegram implements IMessenger {

    public String title;

    public Telegram(String title) {
        this.title = title;
    }

    @Override
    public void getMessage() {

    }

    @Override
    public void sendMessage() {

    }

    @Override
    public String getTitle() {
        return title;
    }

}
