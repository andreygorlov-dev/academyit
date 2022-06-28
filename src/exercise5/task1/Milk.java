package exercise5.task1;

import java.util.Date;

public class Milk extends Product {

    private Date date;

    public Milk(float price, float weight, String name, Date date) {
        super(price, weight, name);
        this.date = date;
        this.title = "Молоко";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "; дата производства: " + date;
    }
}
