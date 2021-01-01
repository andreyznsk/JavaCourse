package ru.JavaLevel2.Lesson7.server;

<<<<<<< HEAD
import java.sql.*;
public class BaseAuthService implements AuthService {

        private static Connection connection;
        private static Statement stmt;
        private static PreparedStatement psSelect;

        private static void prepareAllStatements() throws SQLException {
            psSelect = connection.prepareStatement("SELECT nickname FROM users WHERE login = ? AND password = ?;");
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
=======

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class BaseAuthService implements AuthService {

    private static Map<User, String> USERS = null;
>>>>>>> lesson3_2_test

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
<<<<<<< HEAD
            disconnect();
=======

>>>>>>> lesson3_2_test
        }

        @Override
        public String getNickByLoginPass(String login, String password) {//Изменил на метод идентификации из БД.
<<<<<<< HEAD
            /*User requestedUser = new User(login, password, null);
            return USERS.get(requestedUser);*/
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
=======

            return USERS.get(new User(login, password, null));

>>>>>>> lesson3_2_test
        }

    @Override
    public int insertUser(String login, String password, String nickname) {
        System.out.println("Can`t create new User, cause not dataBase");
        return 0;
    }

    @Override
    public int updateUser(String login, String password, String nickname) {
        System.out.println("Can`t update User, cause not dataBase");
        return 0;
    }
}


