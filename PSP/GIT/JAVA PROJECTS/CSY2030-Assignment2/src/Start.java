import java.io.*;
import java.util.ArrayList;

public class Start {
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<Vehicle> vehicles = new ArrayList<>();

    // Loads customers and vehicles from file
    public static void loadFile() {
        try {
            ObjectInputStream customersFile = new ObjectInputStream(new FileInputStream("customers.dat"));
            ObjectInputStream vehiclesFile = new ObjectInputStream(new FileInputStream("vehicles.dat"));

            customers = (ArrayList<Customer>) customersFile.readObject();
            customersFile.close();

            vehicles = (ArrayList<Vehicle>) vehiclesFile.readObject();
            vehiclesFile.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Writes customers and vehicles from file
    public static void writeFile() {
        // Saves vehicles and customers objects in the files before app closes
        try {
            ObjectOutputStream customersFile = new ObjectOutputStream(new FileOutputStream("customers.dat"));
            customersFile.writeObject(Start.customers);
            customersFile.close();

            ObjectOutputStream vehiclesFile = new ObjectOutputStream(new FileOutputStream("vehicles.dat"));
            vehiclesFile.writeObject(Start.vehicles);
            vehiclesFile.close();

        } catch (IOException io) {
            System.out.println(io);
        }
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        loadFile();

        Car tesla = new Car("Tesla", 300, "XYZ123", 250.0, "Electric", 5);
        Car audi = new Car("Audi", 200, "ABC789", 150.0, "Gas", 5);
//        vehicles.add(tesla);
//        vehicles.add(audi);
        System.out.println(customers);
        System.out.println(vehicles);
        Login login = new Login("Login/Register");
    }
}
