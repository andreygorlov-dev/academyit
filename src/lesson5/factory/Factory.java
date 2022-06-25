package lesson5.factory;

import java.util.Arrays;

public class Factory {

    private String titleFactory;
    private String[] validTitleCar;

    public Factory(String titleFactory, String[] validTitleCar) {
        this.titleFactory = titleFactory;
        this.validTitleCar = validTitleCar;
        System.out.println("Вы сотрудничаете с заводом " + titleFactory);
    }

    public String getTitleFactory() {
        return titleFactory;
    }

    public void setTitleFactory(String titleFactory) {
        this.titleFactory = titleFactory;
    }

    public String[] getValidTitleCar() {
        return validTitleCar;
    }

    public void setValidTitleCar(String[] validTitleCar) {
        this.validTitleCar = validTitleCar;
    }

    public boolean isValidTitleCar(String titleCar) {
        return Arrays.asList(validTitleCar).contains(titleCar);
    }

    public Car createCar(String titleCar) {
        if (isValidTitleCar(titleCar)) {
            System.out.println("Начинается сборка авто " + titleCar);
            return new Car(titleCar, (int) (Math.random() * 4000 + 5000));
        }
        System.out.println("Не возможно создать авто " + titleCar);
        return null;
    }

}
