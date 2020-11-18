package com.property.manager.Manager;

import com.property.manager.Models.Admin;
import com.property.manager.Models.FileManager;

import java.util.ArrayList;
import java.util.List;

public class AdminManager {

    private List<Admin> adminList;
    private String fileName = "admin.dat";
    private FileManager fileManager;

    public AdminManager() {
        fileManager = new FileManager(fileName);
        adminList = (List<Admin>)fileManager.ReadFile();
        if(adminList == null) {
            adminList = new ArrayList<>();
            Admin admin = new Admin("Halima Habbib","admin","1234");
            addAdmin(admin);
        }
    }

    private void addAdmin(Admin admin){
        adminList.add(admin);
        fileManager.saveFile(adminList);
    }

    public Admin getAdmin(){
        return adminList.get(0);
    }

}