package exercise4.task3;

public class Employer {
    String fio;
    int salary;
    int age;
    int id;

//    Конструктор - это метод, который называется по имени класса и вызывается
//    при создании объекта через оператор new. Конструктор не содержит return

    Employer(String fio,int salary,int age,int id){
//        this - это ссылка на объект, который вызывает наш метод(конструктор)
        this.id = id;
        this.fio = fio;
        this.age = age;
        this.salary = salary;
    }

    static Employer getManWithMaxSalary(Employer men[]){
        Employer manMax = men[0];//пусть первый сотрудник имеет максимальный оклад
        for (var i = 1;i < men.length;i++){
            if(manMax.salary < men[i].salary){
                manMax = men[i];
            }
        }
        return manMax;
    }

    static Employer getManWithMinSalary(Employer men[]){
        Employer manMin = men[0];//пусть первый сотрудник имеет максимальный оклад
        for (var i = 1;i < men.length;i++){
            if(manMin.salary > men[i].salary){
                manMin = men[i];
            }
        }
        return manMin;
    }

    static void showMen(Employer men[],boolean conditions){
        if(conditions) {
            for (var man : men) {
                if (man.salary > 50000) {
                    System.out.println(man.fio + " зарабатывает " + man.salary);
                }
            }
        }else{
            for (var man : men) {
                System.out.println(man.fio + " зарабатывает " + man.salary);
            }
        }
    }

    String getInfo(){
        return "Сотрудник " + fio + " зарабатывает " + salary + ". Его возраст " + age;
    }
}
