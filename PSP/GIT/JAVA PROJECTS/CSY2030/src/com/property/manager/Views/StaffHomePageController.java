package com.property.manager.Views;

import com.jfoenix.controls.JFXTextField;
import com.property.manager.Manager.PropertyManager;
import com.property.manager.Models.Property;
import com.property.manager.TableModels.PropertyTable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StaffHomePageController implements Initializable {
    @FXML
    MenuBar menuBarTop;

    @FXML
    TableView<PropertyTable> propertiesTable;
    @FXML
    TableView<PropertyTable> soldPropertiesTable;

    @FXML
    public TableColumn<PropertyTable, String> address;
    @FXML
    public TableColumn<PropertyTable, String> noroom;
    @FXML
    public TableColumn<PropertyTable, String> sellingprice;
    @FXML
    public TableColumn<PropertyTable, String> soldprice;
    @FXML
    public TableColumn<PropertyTable, String> nofloors;
    @FXML
    public TableColumn<PropertyTable, String> monthlyrent;
    @FXML
    public TableColumn<PropertyTable, String> garden;
    @FXML
    public TableColumn<PropertyTable, String> garage;
    @FXML
    public TableColumn<PropertyTable, String> soldAddress;
    @FXML
    public TableColumn<PropertyTable, String> soldPrice;


    @FXML
    JFXTextField searchBar;

    List<PropertyTable> propertyTableList;
    List<PropertyTable> searchPropertiesList;
    List<PropertyTable> soldPropertyTableList;
    List<Property> propertyList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        addData();
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        noroom.setCellValueFactory(new PropertyValueFactory<>("noroom"));
        sellingprice.setCellValueFactory(new PropertyValueFactory<>("sellingprice"));
        soldprice.setCellValueFactory(new PropertyValueFactory<>("soldprice"));
        nofloors.setCellValueFactory(new PropertyValueFactory<>("nofloors"));
        monthlyrent.setCellValueFactory(new PropertyValueFactory<>("monthlyrent"));
        garden.setCellValueFactory(new PropertyValueFactory<>("garden"));
        garage.setCellValueFactory(new PropertyValueFactory<>("garage"));
        soldAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        soldPrice.setCellValueFactory(new PropertyValueFactory<>("soldprice"));
        propertiesTable.setItems(FXCollections.observableArrayList(propertyTableList));
        soldPropertiesTable.setItems(FXCollections.observableArrayList(soldPropertyTableList));

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            searchProperties(newValue);
        });

    }

    @FXML
    private void handleHouseButton(ActionEvent event) {
        openAddHousePage(event);
    }

    private void openAddHousePage(Event e){
        try {
            int width = (int) Screen.getPrimary().getBounds().getWidth();
            int height = (int) Screen.getPrimary().getBounds().getHeight();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddHouse.fxml"));
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
    private void handleFlatButton(ActionEvent event) {
        openAddFlatPage(event);
    }

    private void openAddFlatPage(Event e){
        try {
            int width = (int) Screen.getPrimary().getBounds().getWidth();
            int height = (int) Screen.getPrimary().getBounds().getHeight();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddFlat.fxml"));
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
    private void handleDetailsOfFlatButton(ActionEvent event) {
        openShowDetailsOfFlat(event);
    }

    private void openShowDetailsOfFlat(Event e){
        try {
            int width = (int) Screen.getPrimary().getBounds().getWidth();
            int height = (int) Screen.getPrimary().getBounds().getHeight();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowDetailsOfFlat.fxml"));
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
    private void handleDetailsOfHouseButton(ActionEvent event) {
        openShowDetailsOfHouse(event);
    }

    private void openShowDetailsOfHouse(Event e){
        try {
            int width = (int) Screen.getPrimary().getBounds().getWidth();
            int height = (int) Screen.getPrimary().getBounds().getHeight();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowDetailsOfHouse.fxml"));
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

    private void addData(){
        propertyTableList = new ArrayList<>();
        soldPropertyTableList = new ArrayList<>();
        searchPropertiesList = new ArrayList<>();
        propertyList = new PropertyManager().getPropertyList();
        for (Property property : propertyList) {
            if(!property.isSold())
                propertyTableList.add(new PropertyTable(
                        property.getId(),
                        property.getAddress(),
                        property.getNoroom(),
                        property.getSellingprice(),
                        property.getSoldprice(),
                        property.getNofloors(),
                        property.getMonhtlyRent(),
                        property.isGarden(),
                        property.isGarage()
                ));
            else
                soldPropertyTableList.add(new PropertyTable(
                        property.getId(),
                        property.getAddress(),
                        property.getNoroom(),
                        property.getSellingprice(),
                        property.getSoldprice(),
                        property.getNofloors(),
                        property.getMonhtlyRent(),
                        property.isGarden(),
                        property.isGarage()
                ));

        }
    }

    private void searchProperties(String keyword){
        if(keyword.equals(""))
            propertiesTable.setItems(FXCollections.observableArrayList(propertyTableList));
        else
        {
            searchPropertiesList.clear();
            for(PropertyTable pt : propertyTableList) {
                String ad = pt.getAddress();
                if (ad.toLowerCase().contains(keyword.toLowerCase().trim()))
                    searchPropertiesList.add(pt);
            }

            propertiesTable.setItems(FXCollections.observableArrayList(searchPropertiesList));
        }


    }

}