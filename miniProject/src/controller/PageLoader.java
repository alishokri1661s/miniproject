package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.nio.file.Paths;

public class PageLoader {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 550;
    private static Stage stage;
    public static void initStage(Stage primaryStage) {
        stage = primaryStage;
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        stage.setResizable(false);
        stage.initStyle(StageStyle.DECORATED);
        stage.getIcons().add(new Image(Paths.get("resources/image/hodhod.png").toUri().toString()));
    }

    public void load(String url,String title) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(url));
        stage.setTitle(title);
        stage.setScene(new Scene(root,WIDTH,HEIGHT));
        stage.show();
    }
}
