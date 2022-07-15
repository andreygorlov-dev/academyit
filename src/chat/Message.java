package chat;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private User user;
    private String text;
    private Date dateTime;

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
        return user.getName() + " || " + dateTime + " || " + text;
    }
}
