package exercise5.task1;

public class Product {

    protected String title;
    private float price;
    private float weight;
    private String name;

    public Product(float price, float weight, String name) {
        this.price = price;
        this.weight = weight;
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return title + " с наименованием: " + name + "; цена: " + String.format("%.2f", price) + "; вес: " + String.format("%.2f", weight);
    }


}
