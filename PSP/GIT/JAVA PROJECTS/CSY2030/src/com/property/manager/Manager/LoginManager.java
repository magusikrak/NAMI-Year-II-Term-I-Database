package com.property.manager.Manager;

import com.property.manager.Models.Admin;
import com.property.manager.Models.Branch;
import com.property.manager.Models.FileManager;

public class LoginManager {

    AdminManager adminManager;
    BranchManager branchManager;

    public LoginManager() {
        adminManager = new AdminManager();
        branchManager = new BranchManager();

    }

    public boolean checkLogin(String username ,String password){

        if(username.equals("admin")) {
            Admin admin = adminManager.getAdmin();
            if (admin.getPassword().equals(password))

                return true;
        }
        else
        {
            for(Branch branch:branchManager.getBranchList()) {
                if(branch.getUserName().equals(username) && branch.getPassword().equals(password))
                    return true;

            }
        }



        return false;

    }
}
