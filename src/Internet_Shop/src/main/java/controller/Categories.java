package controller;

import com.google.gson.Gson;
import model.CategoryModel;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/categories")
public class Categories extends HttpServlet {

    private Session session;

    @Override
    public void init() throws ServletException {
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(CategoryModel.class).buildSessionFactory();
        session = factory.getCurrentSession();
        session.beginTransaction();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        req.setCharacterEncoding("UTF-8");
        List<CategoryModel> categoryList = session.createQuery("FROM CategoryModel", CategoryModel.class).list();
        writer.append(new Gson().toJson(categoryList));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        CategoryModel categoryModel = new CategoryModel(req.getParameter("title"));
        session.save(categoryModel);
        session.getTransaction().commit();
    }

    @Override
    public void destroy() {
        session.close();
    }
}
