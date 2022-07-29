package exercise16;

import javax.xml.xpath.XPathExpressionException;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Map;

public class OrmSecond {

    private final Connection connection;
    private final Statement statement;
    private PreparedStatement preparedStatement;
    private static OrmSecond object;

    private OrmSecond() throws ClassNotFoundException, SQLException, XPathExpressionException, FileNotFoundException {
        Config config = new Config("D:\\Programm\\Java\\academyit\\src\\exercise16\\connection.xml");
        Class.forName(config.getDriver());
        var url = config.getDB();
        connection = DriverManager.getConnection(url, config.getLogin(), config.getPass());
        statement = connection.createStatement();

    }

    public static OrmSecond getInstance() throws SQLException, ClassNotFoundException, XPathExpressionException, FileNotFoundException {
        if (object == null) {
            object = new OrmSecond();
        }
        return object;
    }

    public static void showCarByName(String name) throws SQLException, ClassNotFoundException, XPathExpressionException, FileNotFoundException {
        try (ResultSet resultSet = select("CARS", new String[]{"title", "price", "description"}, "WHERE title = '" + name + "'")) {
            while (resultSet.next()) {
                System.out.println("Автомобиль " +
                        resultSet.getString("title") + " стоит " + resultSet.getInt("price") + " описание " + resultSet.getString("description"));
            }
        }
    }

    public static ResultSet select(String table, String[] fields, String where) throws SQLException, ClassNotFoundException, XPathExpressionException, FileNotFoundException {
        return getInstance().selectQuery(table, fields, where);
    }

    private ResultSet selectQuery(String table, String[] fields, String where) throws SQLException {
        if (isConnectionNull()) {
            return null;
        }

        String selectFields = "";
        int countFields = fields.length;
        if (countFields == 0) {
            selectFields = "*";
        } else {
            for (var i = 0; i < countFields; i++) {
                selectFields += fields[i] + (i < countFields - 1 ? "," : "");
            }
        }
        return statement.executeQuery("SELECT "
                + selectFields + " FROM " + table + " " + where);
    }

    //    insert into table(f1,f2) values(v1,v2)
    public static boolean insert(String table, Map<String, String> values) throws SQLException, ClassNotFoundException, XPathExpressionException, FileNotFoundException {
        return getInstance().insertQuery(table, values);
    }

    private boolean insertQuery(String table, Map<String, String> values) throws SQLException {
        if (isConnectionNull()) {
            return false;
        }

        String sql = "INSERT INTO " + table;
        String sqlValues = "";
        String sqlColumns = "";
        if (values.size() > 0 && !table.isEmpty()) {
            var i = 0;
            for (var item : values.entrySet()) {
                sqlColumns += item.getKey() + (i < values.size() - 1 ? "," : "");//строка с названиями столбцов

                if (item.getKey().equals("price")) {
                    sqlValues += item.getValue() + (i < values.size() - 1 ? "," : "");
                } else {
                    sqlValues += "'" + item.getValue() + "'" + (i < values.size() - 1 ? "," : "");
                }
                i++;
            }
            sql += "(" + sqlColumns + ") VALUES(" + sqlValues + ")";
            return statement.executeUpdate(sql) > 0;
        }

        return false;
    }

    public static boolean delete(String table, int id) throws SQLException, ClassNotFoundException, XPathExpressionException, FileNotFoundException {
        return getInstance().deleteQuery(table, id);
    }

    private boolean deleteQuery(String table, int id) throws SQLException {
        if (isConnectionNull()) {
            return false;
        }

        preparedStatement = connection.prepareStatement("DELETE FROM " + table + " WHERE id = ?");
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    //    UPDATE table SET field = value, field2 = value2 Where ...
    public static boolean update(String table, Map<String, String> values, String where) throws SQLException, ClassNotFoundException, XPathExpressionException, FileNotFoundException {
        return getInstance().updateQuery(table, values, where);
    }

    private boolean updateQuery(String table, Map<String, String> values, String where) throws SQLException {
        if (isConnectionNull()) {
            return false;
        }

        String sql = "UPDATE " + table + " SET ";
        String parts = "";
        if (values.size() > 0 && !table.isEmpty()) {
            var i = 0;
            for (var item : values.entrySet()) {
                if (item.getKey().equals("price")) {
                    parts += item.getKey() + "=" + item.getValue() + (i < values.size() - 1 ? "," : "");
                } else {
                    parts += item.getKey() + "='" + item.getValue() + "'" + (i < values.size() - 1 ? "," : "");//строка с названиями столбцов
                }
                i++;
            }
            sql += parts + where;
            return statement.executeUpdate(sql) > 0;
        }
        return false;
    }

    private boolean isConnectionNull() {
        return connection == null;
    }

}
