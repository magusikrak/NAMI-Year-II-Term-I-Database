package com.property.manager.Views;

import com.jfoenix.controls.JFXTextField;
import com.property.manager.Manager.BranchManager;
import com.property.manager.Models.Branch;
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
import java.util.List;
import java.util.ResourceBundle;


public class AddBranchController implements Initializable {

    BranchManager branchManager;
    @FXML
    JFXTextField name,address,phone,email,web,username,password;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        branchManager = new BranchManager();
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        openAdminPage(event);
    }

    private void openAdminPage(Event e){
        try {
            int width = (int) Screen.getPrimary().getBounds().getWidth();
            int height = (int) Screen.getPrimary().getBounds().getHeight();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHomePage.fxml"));
            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
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
    private void handleAddButton(ActionEvent event) {
        addBranch();
        openAdminPage(event);
    }

    private void addBranch(){
        Branch branch = new Branch(
                name.getText(),
                address.getText(),
                phone.getText(),
                email.getText(),
                web.getText(),
                username.getText(),
                password.getText()
        );
        branchManager.addBranch(branch);
    }

}