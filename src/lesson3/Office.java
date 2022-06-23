package lesson3;

public class Office {
    /**
     *
     * @param countMen - количество сотрудников
     * @param address - адрес офиса
     * @return массив сотрудников с окладами
     */
    static int[] getOffice(int countMen,String address){
        System.out.println("Адрес офиса: " + address);
        int office[] = new int[countMen];
        for(var i = 0;i < office.length;i++){
            office[i] = (int) (Math.random() * 160000 + 40000);
            System.out.println("Сотрудник №" + (i + 1) + " зарабатывает " + office[i]);
        }
        System.out.println("-----------------------------");
        System.out.println("Максимальный оклад в данном офисе: " + getMaxPayment(office));
        System.out.println("-----------------------------");

        return office;
    }

    static int getMaxPayment(int payments[]){
//        Пусть первый элемент массива является максимальным
        int max = payments[0];
        for(var i = 1;i < payments.length;i++){
            if(max < payments[i]){
                max = payments[i];//текущий оклад оказался больше предпологаемого
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int office1[] = getOffice(15,"Московская 8");
        int office2[] = getOffice(10,"Чернышевского 15");
        int office3[] = getOffice(20,"Рабочая 11");

        int maxPaymentFromOffice[] = {getMaxPayment(office1),getMaxPayment(office2),getMaxPayment(office3)};
        System.out.println("Максимальный оклад из трех офисов: " + getMaxPayment(maxPaymentFromOffice));
        System.out.println("Средний оклад в офисе 1: " + String.format("%.2f", getAveragePayment(office1)));
        System.out.println("Средний оклад в офисе 2: " + String.format("%.2f", getAveragePayment(office2)));
        System.out.println("Средний оклад в офисе 3: " + String.format("%.2f", getAveragePayment(office3)));
    }

    private static float getAveragePayment(int[] payments) {
        float sum = 0f;
        for (int item : payments) {
            sum += item;
        }
        return sum / payments.length;
    }
}
