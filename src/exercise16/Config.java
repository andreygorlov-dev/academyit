package exercise16;

import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Config {

    private String driver;
    private String db;
    private String login;
    private String pass;

    public Config(String path) throws FileNotFoundException, XPathExpressionException {
        XPathFactory factory = XPathFactory.newInstance();
        XPath parser = factory.newXPath();
        driver = (String) parser.compile("//config/driverName").evaluate(new InputSource(new FileReader(path)), XPathConstants.STRING);
        db = (String) parser.compile("//config/db/url").evaluate(new InputSource(new FileReader(path)), XPathConstants.STRING);
        login = (String) parser.compile("//config/db/login").evaluate(new InputSource(new FileReader(path)), XPathConstants.STRING);
        pass = (String) parser.compile("//config/db/password").evaluate(new InputSource(new FileReader(path)), XPathConstants.STRING);

    }

    public String getDriver() {
        return driver;
    }

    public String getDB() {
        return db;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public void showData() {
        System.out.println(driver + " " + db + " " + login + " " + pass);
    }
}
