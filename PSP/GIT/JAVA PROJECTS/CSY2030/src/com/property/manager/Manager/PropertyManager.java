package com.property.manager.Manager;

import com.property.manager.Models.FileManager;
import com.property.manager.Models.Property;

import java.util.ArrayList;
import java.util.List;

public class PropertyManager {

    private List<Property> propertyList;
    private String fileName = "house.dat";
    private FileManager fileManager;

    public PropertyManager() {
        fileManager = new FileManager(fileName);
        propertyList = (List<Property>)fileManager.ReadFile();
        if(propertyList == null)
            propertyList = new ArrayList<>();
    }

    public void addProperty(Property property){
        propertyList.add(property);
        fileManager.saveFile(propertyList);
    }

    public void deleteProperty(long id){
        int p = -1;
        for(Property property : propertyList)
            if(property.getId() == id)
                p = propertyList.indexOf(property);
            if(p !=-1)
            {
                propertyList.remove(p);
                fileManager.saveFile(propertyList);
            }

    }

    public void modifyProperty(Property mhouse, long id){
        int p = -1;
        for(Property property : propertyList)
            if(property.getId() == id)
                p = propertyList.indexOf(property);
        if(p !=-1)
        {
            propertyList.remove(p);
            propertyList.add(p,mhouse);
            fileManager.saveFile(propertyList);
        }

    }

    public Property getPropertyById(long id){
        for(Property property:propertyList)
            if(property.getId() == id)
                return property;
            return null;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

}