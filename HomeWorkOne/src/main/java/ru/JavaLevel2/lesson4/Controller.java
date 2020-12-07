package ru.JavaLevel2.lesson4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    List<String> messages = new ArrayList<>();



    @Override
    public void initialize(URL location, ResourceBundle resources){
    textArea.setText("No Text");

    }

    public void buttonExitAction() {
        Platform.exit();
    }

    public void buttonSendAction(ActionEvent actionEvent) {
        messages.add("123");
        String str = "";

        for (String s : messages
        ) { str += s + '\n';
        }
        textArea.setText(str);
    }
}
