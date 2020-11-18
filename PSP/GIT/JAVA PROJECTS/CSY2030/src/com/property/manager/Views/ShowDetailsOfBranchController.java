package com.property.manager.Views;

import com.property.manager.Manager.BranchManager;
import com.property.manager.Models.Branch;
import com.property.manager.TableModels.BranchTable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShowDetailsOfBranchController implements Initializable {

    @FXML
    TableView<BranchTable> table;

    @FXML
    public TableColumn<BranchTable, String> name;
    @FXML
    public TableColumn<BranchTable, String> address;
    @FXML
    public TableColumn<BranchTable, String> phoneNumber;
    @FXML
    public TableColumn<BranchTable, String> email;
    @FXML
    public TableColumn<BranchTable, String> webAddress;
    @FXML
    public TableColumn<BranchTable, String> userName;
    @FXML
    public TableColumn<BranchTable, String> password;

    List<BranchTable> branchTableList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addData();
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        webAddress.setCellValueFactory(new PropertyValueFactory<>("webAddress"));
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        table.setItems(FXCollections.observableArrayList(branchTableList));
    }

    private void addData(){
        branchTableList = new ArrayList<>();
        for (Branch branch: new BranchManager().getBranchList())
        {
            branchTableList.add(new BranchTable(
                    branch.getName(),
                    branch.getAddress(),
                    branch.getPhoneNumber(),
                    branch.getEmail(),
                    branch.getWebAddress(),
                    branch.getUserName(),
                    branch.getPassword()

            ));
        }
    }


}
