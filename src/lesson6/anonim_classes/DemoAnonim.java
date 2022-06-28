package lesson6.anonim_classes;


public class DemoAnonim {

    public void g() {
        Test test = new Test() {
            @Override
            public void f() {
                super.f();
                System.out.println("Доп инфо");
            }
        };
        test.f();
    }

}
