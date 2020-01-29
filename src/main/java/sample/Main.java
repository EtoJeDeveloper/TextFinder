package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root,750, 480);

        primaryStage.setTitle("Text Finder");
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(480);
        primaryStage.setMinWidth(750);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
