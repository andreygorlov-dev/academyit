package exercise6;

public abstract class Product {

    protected float price = 100f;
    private String title;

    public Product(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract float calculatedPrice();
}
