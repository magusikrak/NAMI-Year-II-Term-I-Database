package com.property.manager.Models;

import java.io.*;

public class FileManager {

    String filePath;

    public FileManager(String fileName) {
        this.filePath = "Data/"+fileName;
    }

    public Object ReadFile() {
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            return in.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveFile(Object object) {
            try
            {
                FileOutputStream fileOut =  new FileOutputStream(filePath, false);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(object);
                out.close();
                fileOut.close();
            }
            catch (IOException i)
            {
                i.printStackTrace();
            }
    }

}
