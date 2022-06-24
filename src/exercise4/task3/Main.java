package exercise4.task3;

//Существует два вида методов - статические и нестатические. Статические методы -
//это методы, которые не привязаны к объекту класса, они относятся к классу. То есть
//это обычные функции, которые что-либо выполняют. Есть подсказка - если в методе нет
//this - делайте его статическим! Нестатические методы относятся к объекту класса и не могут
//быть вызваны без объекта. Статические методы вызываем по имени класса либо напрямую,
//если они находятся в текущем классе

/**
 *В программе «ОФИС» создать метод для нахождения среднего оклада всех сотрудников
 */
public class Main {
    public static void main(String[] args) {
        Employer man1 = new Employer("Иванов",50000,24,1);
        Employer man2 = new Employer("Петров",90000,29,2);
        Employer man3 = new Employer("Сидоров",80000,26,3);

        Employer officeMen[] = {man1,man2,man3};
        System.out.println("Исходная информация о сотрудниках");
        Employer.showMen(officeMen,false);

        System.out.println("Средний оклад всех сотрудников: " + String.format("%.2f", Office.getAverageSalary(officeMen)));

        Employer manMax = Employer.getManWithMaxSalary(officeMen);
        System.out.println("Сотрудник " + Employer.getManWithMaxSalary(officeMen).fio + " имеет максимальный оклад");
        Employer manMin = Employer.getManWithMinSalary(officeMen);

//        System.out.println("Сотрудник " + manMax.fio + " имеет максимальный оклад: " + manMax.salary);
//        Employer.showMenWithCondtions(officeMen,true);

        //Применим взыскание и премию
        for(var man : officeMen){
            if(man.id == manMax.id){
                Office.setMotivation(man,-20);
            }
            else if(man.id == manMin.id){
                Office.setMotivation(man,10);
            }
        }


        System.out.println("Информация о сотрудниках с учетом премии/взыскания");
        Employer.showMen(officeMen,false);


    }
}
