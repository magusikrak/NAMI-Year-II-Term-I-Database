package com.property.manager.Views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Splash.fxml"));
        root.getStylesheets().add(getClass().getResource("dark-theme.css").toString());
        primaryStage.setTitle("Property System");
        primaryStage.setScene(new Scene(root, 1024, 640));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
