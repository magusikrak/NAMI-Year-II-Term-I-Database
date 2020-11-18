package com.property.manager.Manager;

import com.property.manager.Models.Branch;
import com.property.manager.Models.FileManager;

import java.util.ArrayList;
import java.util.List;

public class BranchManager {

    private List<Branch> branchList;
    private String fileName = "branch.dat";
    private FileManager fileManager;

    public BranchManager() {
        fileManager = new FileManager(fileName);
        branchList = (List<Branch>)fileManager.ReadFile();
        if(branchList == null)
            branchList = new ArrayList<>();
    }

    public void addBranch(Branch branch){
        branchList.add(branch);
        fileManager.saveFile(branchList);
    }

    public List<Branch> getBranchList() {
        return branchList;
    }

}