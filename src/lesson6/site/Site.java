package lesson6.site;

public class Site extends Template {

    public Site(String title) {
        super(title);
    }

    @Override
    public String getContent() {
        return "Блок Содержимое сайта " + TITLE_SITE;
    }

}
