package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Admin;
import model.Student;
import model.Teacher;
import model.User;


public class LoginController {

    @FXML
    Button enterbtn;
    @FXML
    PasswordField password;
    @FXML
    TextField username;
    @FXML
    Label wrongpass;

    public static User user;

    public void login(ActionEvent actionEvent) throws Exception {
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            wrongpass.setText("The fields can't be empty!");
            wrongpass.setVisible(true);
            return;
        }

        int temp = User.search(username.getText());
        if (temp == -1) {
            wrongpass.setText("User not found!");
            wrongpass.setVisible(true);
            return;
        }

        user = User.ALL_USERS.get(temp);
        if (!(password.getText().equals(user.getPassword()))) {
            wrongpass.setText("Wrong password!");
            wrongpass.setVisible(true);
            return;
        }
        if (user instanceof Admin)
            new PageLoader().load("/view/adminMain.fxml", "Admin controller    --Boustan--");
        else if (user instanceof Teacher)
            new PageLoader().load("/view/teacherMain.fxml", "Teacher controller    --Boustan--");
        else if (user instanceof Student)
            new PageLoader().load("/view/studentMain.fxml", "Student controller    --Boustan--");

    }
}
