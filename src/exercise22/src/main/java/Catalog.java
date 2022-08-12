

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/catalog")
public class Catalog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connect;
	Statement stmt;
	PrintWriter writer = null;
	
	@Override
	public void init() throws ServletException {
        var url = "jdbc:mysql://localhost/" + Config.DB;
        try {
			Class.forName(Config.DRIVER);
			connect = DriverManager.getConnection(url, Config.LOGIN, Config.PASS);
			stmt = connect.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		writer = response.getWriter();
		String idStr = request.getParameter("id");
		String action = request.getParameter("action");
		try {
			switch (action) {
				case "getMarki":
					getMarki();
					break;
				case "getModel":
					getModels(Integer.parseInt(idStr));
					break;
				case "getInfo":
					getInfo(Integer.parseInt(idStr));
					break;
				default:
					break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void getInfo(int idModel) throws SQLException {
		String sql = "select marki.marka, models.title, models.description, models.price, models.weight from models models \r\n"
				+ "inner join marki marki on models.id_mark = marki.id\r\n"
				+ "where models.id_model =" + idModel;
		try (ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String data = String.format("%s %s \nОписание: %s;\nЦена: %f;\nВес: %d", rs.getString("marka"), rs.getString("title"), 
						rs.getString("description"), rs.getFloat("price"), rs.getInt("weight"));
				writer.append(data);
			}
		}
	}

	private void getModels(int idMark) throws SQLException {
		String sql = "select id_model, title from  models where id_mark=" + idMark;
		try (ResultSet rs = stmt.executeQuery(sql)) {
			while(rs.next()) {
				writer.append("<option value='").append(Integer.toString(rs.getInt("id_model"))).append("'>");
				writer.append(rs.getString("title")).append("</option>");
			}
		}
	}

	private void getMarki() throws SQLException {
		String sql = "select * from marki";
		try (ResultSet rs = stmt.executeQuery(sql)) {
			while(rs.next()) {
				writer.append("<option value='").append(Integer.toString(rs.getInt("id"))).append("'>");
				writer.append(rs.getString("marka")).append("</option>");
			}
		}
	}
	
	@Override
	public void destroy() {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
