package ru.JavaLevel2.Lesson7.server;

import java.sql.*;
public class DataBaseAuthService implements AuthService {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psSelect;
    private static PreparedStatement psInsert;
    private static PreparedStatement psUpdate;

    private static void prepareAllStatements() throws SQLException {
        psSelect = connection.prepareStatement("SELECT nickname FROM users WHERE login = ? AND password = ?;");
        //psUpdate = connection.prepareStatement("UPDATE nickname FROM users WHERE login = ? AND password = ?;");
        psInsert = connection.prepareStatement("INSERT INTO users (login,password,nickname) VALUES(?,?,?)");

    }

    private static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    private static void disconnect() {
        try {
            stmt.close();
            System.out.println("Data base has been closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // private static Map<User, String> USERS = null;

    @Override
    public void start() {
        System.out.println("Auth service is running");
           /* USERS = new HashMap<>();
            USERS.put(new User("2","2","Perter"), "Peter");
            USERS.put(new User("3","3","Alexey"), "Alexey");
            USERS.put(new User("4","4","Oleg"), "Oleg");
            USERS.put(new User("1","1","Andreyz"), "Andreyz");
*/
        try {
            connect();
            prepareAllStatements();
            System.out.println("Connect to bd main is successful");
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            //disconnect();
        }




    }

    @Override
    public void stop() {
        System.out.println("Auth service has been stopped");
        disconnect();
    }

    @Override
    public String getNickByLoginPass(String login, String password) {//Изменил на метод идентификации из БД.

        try {//Блок провеки через подготовленный запрос
            psSelect.setString(1,login);
            psSelect.setString(2,password);
            ResultSet rs = psSelect.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("nickname"));
                return rs.getString("nickname");
            }

        } catch (SQLException throwables) {
            System.err.println(throwables);
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void registration(String login, String password, String nickname) {
        try {//Блок провеки через подготовленный запрос
            psInsert.setString(1,login);
            psInsert.setString(2,password);
            psInsert.setString(3,nickname);
            System.out.printf("Login: %s\npassword: %s\nNickname: %s",login,password,nickname);

            //psInsert.executeUpdate();
            //ResultSet rs = psSelect.executeQuery();


        } catch (SQLException throwables) {
            System.err.println(throwables);
            throwables.printStackTrace();
        }

    }
}

