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
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyFlatController implements Initializable {

    Property property;
    PropertyManager propertyManager;
    @FXML
    JFXTextField address,noroom,sellingprice,soldprice,nofloors,monthlycharge;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void initData(Long id) {
        propertyManager = new PropertyManager();
        this.property = propertyManager.getPropertyById(id);
        address.setText(property.getAddress());
        noroom.setText(property.getNoroom());
        sellingprice.setText(property.getSellingprice());
        soldprice.setText(property.getSoldprice());
        nofloors.setText(property.getNofloors());
        monthlycharge.setText(property.getMonhtlyRent());
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        openFlatDetailsPage(event);
    }

    private void openFlatDetailsPage(Event e){
        try {
            int width = (int) Screen.getPrimary().getBounds().getWidth();
            int height = (int) Screen.getPrimary().getBounds().getHeight();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowDetailsOfFlat.fxml"));
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
    private void handledeleteButton(ActionEvent event) {
        propertyManager.deleteProperty(property.getId());
        openFlatDetailsPage(event);
    }

    @FXML
    private void handleModifyButton(ActionEvent event) {
        modifyFlat();
        openFlatDetailsPage(event);
    }

    @FXML
    private void handleSoldButton(ActionEvent event) {
        markSold();
        openFlatDetailsPage(event);
    }

    private void modifyFlat(){

        Property mflat = new Property(
                address.getText(),
                noroom.getText(),
                sellingprice.getText(),
                soldprice.getText(),
                nofloors.getText(),
                monthlycharge.getText());

        propertyManager.modifyProperty(mflat, property.getId());
    }

    private void markSold(){
        property.setSold(true);
        propertyManager.modifyProperty(property, property.getId());
    }

}