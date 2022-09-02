package controller;

import com.google.gson.Gson;
import model.ProductModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class Products extends HttpServlet {

    private Session session;

    @Override
    public void init() throws ServletException {
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(ProductModel.class).buildSessionFactory();
        session = factory.getCurrentSession();
        session.beginTransaction();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        req.setCharacterEncoding("UTF-8");

        List<ProductModel> productList = session.createQuery("FROM ProductModel WHERE categoryId = :CATEGORY_ID", ProductModel.class)
                .setParameter("CATEGORY_ID", Long.parseLong(req.getParameter("category_id"))).list();

        writer.append(new Gson().toJson(productList));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    public void destroy() {
        session.close();
    }
}
