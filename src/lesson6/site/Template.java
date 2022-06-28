package lesson6.site;

public abstract class Template {

    public static final String TITLE_SITE = "Демо сайт";

    private String title;

    public Template(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getContent();

    public String getHeader() {
        return "Универсальный блок 'Шапка сайта' " + TITLE_SITE;
    }

    public String getFooter() {
        return "Универсальный блок 'Подвал сайта' " + TITLE_SITE;
    }

    public void showPage() {
        System.out.println("Компоненты страницы " + title);
        System.out.println(getHeader());
        System.out.println(getContent());
        System.out.println(getFooter());
        System.out.println();
    }

}
