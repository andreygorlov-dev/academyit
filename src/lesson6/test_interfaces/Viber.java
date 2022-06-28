package lesson6.test_interfaces;

public class Viber implements IMessenger, IUser{

    public String title;

    public Viber(String title) {
        this.title = title;
    }

    @Override
    public void getMessage() {

    }

    @Override
    public void sendMessage() {

    }

    @Override
    public void auth() {

    }

    @Override
    public void reg() {

    }

    @Override
    public void logOut() {

    }

    @Override
    public String getTitle() {
        return title;
    }
}
