package com.property.manager.Views;

import com.property.manager.Manager.PropertyManager;
import com.property.manager.Models.Property;
import com.property.manager.TableModels.PropertyTable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShowDetailsOfHouse  implements Initializable {

    @FXML
    TableView<PropertyTable> table;

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
    public TableColumn<PropertyTable, String> garden;
    @FXML
    public TableColumn<PropertyTable, String> garage;

    List<PropertyTable> propertyTableList;
    List<Property> propertyList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addData();
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        noroom.setCellValueFactory(new PropertyValueFactory<>("noroom"));
        sellingprice.setCellValueFactory(new PropertyValueFactory<>("sellingprice"));
        soldprice.setCellValueFactory(new PropertyValueFactory<>("soldprice"));
        nofloors.setCellValueFactory(new PropertyValueFactory<>("nofloors"));
        garden.setCellValueFactory(new PropertyValueFactory<>("garden"));
        garage.setCellValueFactory(new PropertyValueFactory<>("garage"));
        table.setItems(FXCollections.observableArrayList(propertyTableList));

        table.setRowFactory( tv -> {
            TableRow<PropertyTable> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    PropertyTable rowData = row.getItem();
                    long id = rowData.getId();
                    openHouseModifypage(event, id);
                }
            });
            return row ;
        });
    }

    private void addData(){
        propertyTableList = new ArrayList<>();
        propertyList = new PropertyManager().getPropertyList();
        for (Property property : propertyList)
        {
            if(property.getType().equals("House") && !property.isSold())
                propertyTableList.add(new PropertyTable(
                        property.getId(),
                        property.getAddress(),
                        property.getNoroom(),
                        property.getSellingprice(),
                        property.getSoldprice(),
                        property.getNofloors(),
                        property.isGarden(),
                        property.isGarage()
                ));
        }
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

    private void openHouseModifypage(Event e, long id){
        try {
            int width = (int) Screen.getPrimary().getBounds().getWidth();
            int height = (int) Screen.getPrimary().getBounds().getHeight();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyHouse.fxml"));
            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.setTitle("Property System");
            Scene scene = new Scene(loader.load(),width,height);
            scene.getStylesheets().add(getClass().getResource("dark-theme.css").toString());
            stage.setScene(scene);
            stage.setMaximized(true);
            ModifyHouseController controller = loader.getController();
            controller.initData(id);
        }catch (IOException io){
            io.printStackTrace();
        }

    }

}