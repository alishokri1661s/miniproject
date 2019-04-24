package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.User;


public class StudentMainController {

    @FXML
    Label username, password,userError,passError;
    @FXML
    TextField newUserField;
    @FXML
    PasswordField newPassField;
    @FXML
    Pane userChangePane, passChangePane;
    @FXML
    Button userbtn, passbtn, userChangeOk, passChangeOk;

    private User user=LoginController.user;
    public void initialize() {
        username.setText(user.getUsername());
        password.setText(user.getPassword());
        userChangePane.setVisible(false);
        passChangePane.setVisible(false);
        newPassField.setText("");
        newUserField.setText("");
        passError.setVisible(false);
        userError.setVisible(false);
    }

    public void userChange(ActionEvent actionEvent) {
        initialize();
        userChangePane.setVisible(true);
    }

    public void passChange(ActionEvent actionEvent) {
        initialize();
        passChangePane.setVisible(true);
    }

    public void ChangeUsername(ActionEvent actionEvent) {
        try {
            user.setUsername(newUserField.getText());
            userError.setVisible(false);
            initialize();
        } catch (Exception e) {
            userError.setVisible(true);
        }
    }

    public void ChangePassword(ActionEvent actionEvent) {
        try {
            user.setPassword(newPassField.getText());
            passError.setVisible(false);
            initialize();
        } catch (Exception e) {
            passError.setVisible(true);
        }
    }

    public void logout(ActionEvent actionEvent) throws Exception {
        LoginController.user=null;
        new PageLoader().load("/view/login.fxml", "Login");
    }
}
