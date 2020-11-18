package com.property.manager.Models;

import java.io.Serializable;

public class Property implements Serializable {

    private long id;
    private String address;
    private String noroom;
    private String sellingprice;
    private String soldprice;
    private String nofloors; //for house noo of floors and for flat the floor on the flat
    private String monhtlyRent;
    private String type;
    private boolean garden;
    private boolean garage;
    private boolean sold;


    public Property(String address, String noroom, String sellingprice, String soldprice, String nofloors, boolean garden, boolean garage) {
       this.id = System.currentTimeMillis();
        this.address = address;
        this.noroom = noroom;
        this.sellingprice = sellingprice;
        this.soldprice = soldprice;
        this.nofloors = nofloors;
        this.garden = garden;
        this.garage = garage;
        this.sold = false;
        this.type = "House";
        this.monhtlyRent = "N/A";
    }


    public Property(String address, String noroom, String sellingprice, String soldprice, String nofloors, String monhtlyRent) {
        this.id = System.currentTimeMillis();
        this.address = address;
        this.noroom = noroom;
        this.sellingprice = sellingprice;
        this.soldprice = soldprice;
        this.nofloors = nofloors;
        this.monhtlyRent = monhtlyRent;
        this.sold = false;
        this.type = "Flat";
        this.garden = false;
        this.garage = false;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNoroom() {
        return noroom;
    }

    public void setNoroom(String noroom) {
        this.noroom = noroom;
    }

    public String getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(String sellingprice) {
        this.sellingprice = sellingprice;
    }

    public String getSoldprice() {
        return soldprice;
    }

    public void setSoldprice(String soldprice) {
        this.soldprice = soldprice;
    }

    public String getNofloors() {
        return nofloors;
    }

    public void setNofloors(String nofloors) {
        this.nofloors = nofloors;
    }

    public boolean isGarden() {
        return garden;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public String getMonhtlyRent() {
        return monhtlyRent;
    }

    public void setMonhtlyRent(String monhtlyRent) {
        this.monhtlyRent = monhtlyRent;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public String getType() {
        return type;
    }
}
