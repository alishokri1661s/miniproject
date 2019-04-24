package model;

import controller.PageLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        PageLoader.initStage(primaryStage);
        User.initUsers();
        new PageLoader().load("/view/login.fxml","Login");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
