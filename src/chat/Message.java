package chat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Serializable {
    private static final long serialVersionUID = 7840314799711590029L;

    private final User user;
    private final String text;
    private final Date dateTime;

    public Message(User user, String text, Date dateTime) {
        this.user = user;
        this.text = text;
        this.dateTime = dateTime;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public Date getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return user.getName() + " " + simpleDateFormat.format(dateTime) + " : " + text;
    }

    public void printMessage() {
        System.out.println(this.user.getColor() + this + this.user.getColor());
    }
}
