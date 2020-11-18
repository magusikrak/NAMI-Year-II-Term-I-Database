package com.property.manager.Views;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminHomePageController implements Initializable {

    @FXML
    MenuBar menuBarTop;

    @Override
    public void initialize(URL url, ResourceBundle rb) { }

    @FXML
    private void handleAddBranchButton(ActionEvent event) {
        openAddBranchScene(event);
    }

    private void openAddBranchScene(Event e){
        try {
            int width = (int) Screen.getPrimary().getBounds().getWidth();
            int height = (int) Screen.getPrimary().getBounds().getHeight();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddBranch.fxml"));
            Stage stage = (Stage) menuBarTop.getScene().getWindow();
            stage.setTitle("Property System");
            Scene scene = new Scene(loader.load(),width,height);
            scene.getStylesheets().add(getClass().getResource("dark-theme.css").toString());
            stage.setScene(scene);
            stage.setMaximized(true);
        }catch (IOException io){
            io.printStackTrace();
        }

    }

    @FXML
    private void handleDetailsOfBranchButton(ActionEvent event) {
        openShowDetailsOfBranch(event);
    }

    private void openShowDetailsOfBranch(Event e){
        try {
            int width = (int) Screen.getPrimary().getBounds().getWidth();
            int height = (int) Screen.getPrimary().getBounds().getHeight();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowDetailsOfBranch.fxml"));
            Stage stage = (Stage) menuBarTop.getScene().getWindow();
            stage.setTitle("Property System");
            Scene scene = new Scene(loader.load(),width,height);
            scene.getStylesheets().add(getClass().getResource("dark-theme.css").toString());
            stage.setScene(scene);
            stage.setMaximized(true);
        }catch (IOException io){
            io.printStackTrace();
        }

    }

    @FXML
    private void handleExitButton(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

}