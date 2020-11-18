package com.property.manager.Views;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.property.manager.Manager.LoginManager;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginManager loginManager;
    @FXML
    JFXTextField username;
    @FXML
    JFXPasswordField password;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginManager = new LoginManager();

    }

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
        openSplashScene(event);
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        if(loginManager.checkLogin(username.getText(),password.getText()))
            if(username.getText().equals("admin"))
                openAdminScene(event);
            else
                openStaffScene(event);
        else
            password.setPromptText("Invalid Password..");

    }

    private void openSplashScene(Event e){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Splash.fxml"));
            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.setTitle("Property System");
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("dark-theme.css").toString());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }

    }

    private void openStaffScene(Event e){
        try {
            int width = (int) Screen.getPrimary().getBounds().getWidth();
            int height = (int) Screen.getPrimary().getBounds().getHeight();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StaffHomePage.fxml"));
            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.setTitle("Staff Panel");
            Scene scene = new Scene(loader.load(),width,height);
            scene.getStylesheets().add(getClass().getResource("dark-theme.css").toString());
            stage.setScene(scene);
            stage.setMaximized(true);
        }catch (IOException io){
            io.printStackTrace();
        }

    }

    private void openAdminScene(Event e){
        try {
            int width = (int) Screen.getPrimary().getBounds().getWidth();
            int height = (int) Screen.getPrimary().getBounds().getHeight();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHomePage.fxml"));
            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.setTitle("Admin Panel");
            Scene scene = new Scene(loader.load(),width,height);
            scene.getStylesheets().add(getClass().getResource("dark-theme.css").toString());
            stage.setScene(scene);
            stage.setMaximized(true);
        }catch (IOException io){
            io.printStackTrace();
        }

    }


}