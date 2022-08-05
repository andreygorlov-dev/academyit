
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Catalog 
 * Catalog?action=delete&name=Ауди - Удаление по имени
 * Catalog?action=insert&name=Ауди2&price=44&info=Лучшая&imgName=vw.jpg - добавление
 */
@WebServlet("/Catalog")
public class Catalog extends HttpServlet {

	Connection connect;
	Statement stmt;
	PrintWriter writer = null;

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName(Config.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		var url = "jdbc:mysql://localhost/" + Config.DB;
		try {
			connect = DriverManager.getConnection(url, Config.LOGIN, Config.PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt = connect.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		writer = response.getWriter();
		var action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "card":
				showCardGood(Integer.parseInt(request.getParameter("id")));
				break;
			case "delete":
				deleteGoodsByName(request.getParameter("name"));
				showAllCard();
				break;
			case "insert":
				insertGoods(request.getParameter("name"), Integer.parseInt(request.getParameter("price")),
						request.getParameter("info"), new Date(), request.getParameter("imgName"));
				showAllCard();
				break;
			default:
				break;

			}
		} else {

			showAllCard();
		}
	}

	private void insertGoods(String name, int price, String info, Date date, String imgName) {
		try {

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String strDate = dateFormat.format(date);
			try (PreparedStatement preparedStatement = connect.prepareStatement(
					"INSERT INTO `goods`(`title`, `price`, `info`, `date_income`, `img`) VALUES (?, ?, ?, ?, ?)")) {
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, price);
				preparedStatement.setString(3, info);
				preparedStatement.setDate(4, new java.sql.Date(date.getTime()));
				preparedStatement.setString(5, imgName);
				preparedStatement.addBatch();
				preparedStatement.execute();
				connect.commit();
				preparedStatement.clearBatch();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void showAllCard() {
		var builder = new StringBuilder("<table style=\"text-align: center;margin:0 auto\" border=\"1\" width='800'>");
		var sql = "select * from goods";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				builder.append("<tr><td>").append(rs.getInt("id")).append("</td>");
				builder.append("<td><a href='?action=card&id=").append(rs.getInt("id")).append("'>")
						.append(rs.getString("title")).append("</a></td>");
				builder.append("<td>").append(rs.getInt("price")).append("</td>");
				builder.append("<td><img width='150' src='images/").append(rs.getString("img")).append("'></td>");
			}
			builder.append("</table>");
			writer.append(builder.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteGoodsByName(String name) {
		try {
			stmt.execute("DELETE FROM GOODS WHERE TITLE = '" + name + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showCardGood(int id) {
		if (id > 0) {
			var sql = "select * from goods where id = " + id;
			ResultSet rs = null;
			try {
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (rs.next()) {
					writer.append("<h1 style=\"text-align: center;\">").append(rs.getString("title")).append("</h1");
					writer.append("<table style=\"text-align: center;margin:0 auto\" border=\"1\" width='800'><tr>");
					writer.append("<td>").append(rs.getString("info")).append("</td>");
					writer.append("<td><img width='350' src='images/").append(rs.getString("img"))
							.append("'></td></tr></table>");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
