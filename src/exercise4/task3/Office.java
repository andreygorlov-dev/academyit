package exercise4.task3;

public class Office {
    /**
     * В этом методе сотруднику либо выдаем премию, либо взыскание
     * @param man - сотрудник
     * @param rate - если > 0 - премия, а иначе взыскание
     */
    static void setMotivation(Employer man,int rate){
        if(rate > 0){
            System.out.println("Сотрудник " + man.fio + " получает премию " + rate);
        }else{
            System.out.println("Сотрудник " + man.fio + " получает взыскание " + rate);
        }
        man.salary += man.salary * rate / 100;
    }

    //Сотрудник будет всё же employee
    //Employer - работадатель)))
    public static float getAverageSalary(Employer[] employees) {
        float sum = 0f;

        for (Employer employee : employees) {
            sum += employee.salary;
        }

        return sum / employees.length;
    }

}
