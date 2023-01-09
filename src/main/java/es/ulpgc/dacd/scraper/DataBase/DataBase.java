package es.ulpgc.dacd.scraper.DataBase;

import java.sql.*;
import java.util.List;

public class DataBase {

    public DataBase(){}
    String dbPath = "C:\\Users\\jesus\\IdeaProjects\\scrapper\\HotelsDatabase.db";

    public void createTable() throws SQLException {
        try(Connection conn = connect(dbPath)){
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Hotels (" +
                    "name TEXT PRIMARY KEY, " +
                    "url TEXT NOT NULL" +
                    ")");
        }
    }


    public static Connection connect(String dbPath) throws SQLException {
        Connection conn = null;
        String url = "jdbc:sqlite:" + dbPath;
        conn = DriverManager.getConnection(url);
        return conn;
    }


    public void insert_hotels(String name, String url) throws SQLException {
        String hotels_conn = "INSERT INTO Hotels(name, url) " +
                "VALUES (?,?)";
        try(Connection conn = connect(dbPath)) {
            PreparedStatement preStatement = conn.prepareStatement(hotels_conn);
            preStatement.setString(1,name);
            preStatement.setString(2,url);

            preStatement.executeUpdate();
        }
    }

    public List<String> getUrl() throws SQLException {
        String hotels_conn = "SELECT * FROM Hotels";
        List<String> urls = null;
        try(Connection conn = connect(dbPath)){
            PreparedStatement preStatement = conn.prepareCall(hotels_conn);
            ResultSet res = preStatement.executeQuery(hotels_conn);
            while (res.next()) {
                urls.add(res.getString("url"));
            }
        }
        return urls;
    }
}

