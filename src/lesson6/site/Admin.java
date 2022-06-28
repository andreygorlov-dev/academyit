package lesson6.site;

public class Admin extends Template {

    public Admin(String title) {
        super(title);
    }

    @Override
    public String getContent() {
        return "Блок Содержимое админки " + TITLE_SITE;
    }

}
