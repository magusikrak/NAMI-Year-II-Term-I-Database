package com.property.manager.Views;

import com.jfoenix.controls.JFXTextField;
import com.property.manager.Manager.PropertyManager;
import com.property.manager.Models.Property;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuBar;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddHouseController implements Initializable {

    PropertyManager PropertyManager;
    @FXML
    JFXTextField address,noroom,sellingprice,soldprice,nofloors;
    @FXML
    CheckBox gardenBox,garageBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PropertyManager = new PropertyManager();
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        openStaffPage(event);
    }

    private void openStaffPage(Event e){
        try {
            int width = (int) Screen.getPrimary().getBounds().getWidth();
            int height = (int) Screen.getPrimary().getBounds().getHeight();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StaffHomePage.fxml"));
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
        addHouse();
        openStaffPage(event);
    }

    private void addHouse(){

        Property property = new Property(
                address.getText(),
                noroom.getText(),
                sellingprice.getText(),
                soldprice.getText(),
                nofloors.getText(),
                gardenBox.isSelected(),
                garageBox.isSelected());

        PropertyManager.addProperty(property);
    }

}



