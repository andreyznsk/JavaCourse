package ru.JavaLevel2.Lesson7.server;

import java.util.HashMap;
import java.util.Map;
    public class BaseAuthService implements AuthService {

        private static Map<User, String> USERS = null; /*= Map.of(
                new User("login1", "pass1", "Peter"), "Peter",
                new User("login2", "pass2", "Alexey"), "Alexey",
                new User("login3", "pass3", "Oleg"), "Oleg"
        );
*/

        @Override
        public void start() {
            System.out.println("Auth service is running");
            USERS = new HashMap<>();
            USERS.put(new User("2","2","Perter"), "Peter");
            USERS.put(new User("3","3","Alexey"), "Alexey");
            USERS.put(new User("4","4","Oleg"), "Oleg");
            USERS.put(new User("1","1","Andreyz"), "Andreyz");



        }

        @Override
        public void stop() {
            System.out.println("Auth service has been stopped");
        }

        @Override
        public String getNickByLoginPass(String login, String password) {
            User requestedUser = new User(login, password, null);
            return USERS.get(requestedUser);
        }
    }

