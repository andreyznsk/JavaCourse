package ru.JavaLevel2.Lesson7.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ru.JavaLevel2.Lesson7.client.models.Network;

public class RegController {

  //  private static final String AUTH_CMD = "/auth"; // "/auth login password"

    @FXML
    public TextField loginField;


    @FXML
    public PasswordField passwordField;

    @FXML
    public TextField nicknameField;

    private AuthController controller;

    private Network network;

    @FXML
    public void executeReg(ActionEvent actionEvent) {
        String login = loginField.getText();
        String password = passwordField.getText();
        //String nickname = nicknameField.getText();
        /*if (login == null || login.isEmpty() || password == null || password.isEmpty() || nickname == null || nickname.isEmpty()) {
            ClientChat.showNetworkError("Логин и пароль обязательны!", "Валидация", null);
            return;
        }*/
        System.out.println(login + " " + password + " ");

        /*

        try {
            network.sendAuthMessage(login, password);
        } catch (IOException e) {
            ClientChat.showNetworkError(e.getMessage(), "Auth error!", null);
            e.printStackTrace();
        }*/
    }

    public void setController(AuthController controller) {
        this.controller = controller;
    }

}