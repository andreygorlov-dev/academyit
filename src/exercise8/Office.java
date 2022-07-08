package exercise8;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private List<CarNumber> carNumberList = new ArrayList<>();

    public List<CarNumber> getCarNumberList() {
        return carNumberList;
    }

    /**
     * Добавление номеров автомобилей уникальных по гос номеру
     * @param carNumber
     * @return true объект добавлен в коллекцию / false - не добавлен в коллекцию
     */
    public boolean addCarNumber(CarNumber carNumber) {
        for (CarNumber item : carNumberList) {
            if (item.equals(carNumber)) {
                return false;
            }
        }
        carNumberList.add(carNumber);
        return true;
    }

    /**
     * Поиск владельца по гос номеру машины
     * @param carNumber - гос номер
     * @return - ФИО владельца
     */
    public String findOwner(String carNumber) {
        for (CarNumber item : carNumberList) {
            if (item.equals(carNumber)){
                return item.getNameOwner();
            }
        }
        return null;
    }

    public void showInfo() {
        for (CarNumber item : carNumberList) {
            System.out.println(item.getInfo());
        }
    }

}
