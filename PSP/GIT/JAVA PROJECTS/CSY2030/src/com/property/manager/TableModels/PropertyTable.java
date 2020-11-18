package com.property.manager.TableModels;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import java.io.Serializable;

public class PropertyTable implements Serializable {

    private SimpleLongProperty id;
    private     SimpleStringProperty     address;
    private     SimpleStringProperty     noroom;
    private     SimpleStringProperty     sellingprice;
    private     SimpleStringProperty     soldprice;
    private    SimpleStringProperty     nofloors;
    private SimpleStringProperty garden;
    private SimpleStringProperty garage;
    private SimpleStringProperty monthlyrent;

    public PropertyTable(long id, String address, String noroom, String sellingprice, String soldprice, String nofloors, String monthlyRent, boolean garden, boolean garage) {
        this.id = new SimpleLongProperty(id);
        this.address = new SimpleStringProperty(address);
        this.noroom = new SimpleStringProperty(noroom);
        this.sellingprice = new SimpleStringProperty(sellingprice);
        this.soldprice = new SimpleStringProperty(soldprice);
        this.nofloors = new SimpleStringProperty(nofloors);
        this.monthlyrent = new SimpleStringProperty(monthlyRent);
        if(garden)
            this.garden = new SimpleStringProperty("Yes");
        else
            this.garden = new SimpleStringProperty("No");

        if(garage)
            this.garage = new SimpleStringProperty("Yes");
        else
            this.garage = new SimpleStringProperty("No");
    }

    public PropertyTable(long id, String address, String noroom, String sellingprice, String soldprice, String nofloors, boolean garden, boolean garage) {
        this.id = new SimpleLongProperty(id);
        this.address = new SimpleStringProperty(address);
        this.noroom = new SimpleStringProperty(noroom);
        this.sellingprice = new SimpleStringProperty(sellingprice);
        this.soldprice = new SimpleStringProperty(soldprice);
        this.nofloors = new SimpleStringProperty(nofloors);
        if(garden)
            this.garden = new SimpleStringProperty("Yes");
        else
            this.garden = new SimpleStringProperty("No");

        if(garage)
            this.garage = new SimpleStringProperty("Yes");
        else
            this.garage = new SimpleStringProperty("No");
    }

    public PropertyTable(long id, String address, String noroom, String sellingprice, String soldprice, String nofloors, String monthlyrent) {
        this.id = new SimpleLongProperty(id);
        this.address = new SimpleStringProperty(address);
        this.noroom = new SimpleStringProperty(noroom);
        this.sellingprice = new SimpleStringProperty(sellingprice);
        this.soldprice = new SimpleStringProperty(soldprice);
        this.nofloors = new SimpleStringProperty(nofloors);
        this.nofloors = new SimpleStringProperty(nofloors);
        this.monthlyrent = new SimpleStringProperty(monthlyrent);
    }

    public long getId() {
        return id.get();
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getNoroom() {
        return noroom.get();
    }

    public void setNoroom(String noroom) {
        this.noroom.set(noroom);
    }

    public String getSellingprice() {
        return sellingprice.get();
    }

    public void setSellingprice(String sellingprice) {
        this.sellingprice.set(sellingprice);
    }

    public String getSoldprice() {
        return soldprice.get();
    }

    public void setSoldprice(String soldprice) {
        this.soldprice.set(soldprice);
    }

    public String getNofloors() {
        return nofloors.get();
    }

    public void setNofloors(String nofloors) {
        this.nofloors.set(nofloors);
    }

    public String getMonthlyrent() {
        return monthlyrent.get();
    }

    public void setMonthlyrent(String monthlyrent) {
        this.monthlyrent.set(monthlyrent);
    }

    public String getGarden() {
        return garden.get();
    }

    public void setGarden(boolean garden) {
        if(garden)
            this.garden.set("Yes");
        else
            this.garden.set("No");
    }

    public String getGarage() {
        return garage.get();
    }

    public void setGarage(boolean garage) {
        if(garage)
            this.garage.set("Yes");
        else
            this.garage.set("No");
    }
}
