package lesson5.factory;

public class Main {

    public static void main(String[] args) {
        String[] models = {
                "Гранта",
                "Веста",
                "Нива",
                "X-Ray"
        };

        String[] validModels = {
                "Гранта",
                "Веста",
                "Нива"
        };

        Factory factory = new Factory("АвтоВаз", validModels);
        int count = (int) (Math.random() * 20 + 20);
        Diller diller = new Diller("Элвис", 20);
        diller.createOrder(factory, count, models);
    }

}
