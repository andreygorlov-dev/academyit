package lesson6.site;

public class Page {

    public static void main(String[] args) {
        Template[] pages = {
                new Admin("Администрирование пользователей"),
                new Admin("Администрирование товаров"),
                new Site("Главная страница"),
                new Site("Контакты")
        };

        for (Template page : pages) {
            page.showPage();
        }

    }

}
