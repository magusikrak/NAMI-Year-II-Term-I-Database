//Declares the package
package sugamkarki;

//declares the class
public class Ship {
    //    declares the string variable
    String name;
    //    declares the integer for year
    int year;
    //    declares the integer for capacity
    int capacity;

    //    declares a constructor without any arguments
    public Ship() {
//        sets the value of name to "Titanic"
        this.name = "Titanic";
//        sets the year to 1912
        this.year = 1912;
//        sets the capacity to 2400
        this.capacity = 2400;
    }

    //    declares a constructor which takes name as string, year and capacity as integers
    public Ship(String name, int year, int capacity) {
//    sets this.name to name, this.year to year and this.capacity to capacity from the arguments
        this.name = name;
        this.year = year;
        this.capacity = capacity;
    }

    //declares a getter method which returns name
    public String getName() {
        return this.name;
    }

    //declares a setter method which sets name
    public void setName(String name) {
        this.name = name;
    }

    //declares a getter method which returns year
    public int getYear() {
        return this.year;
    }

    //declares a setter method which sets year
    public void setYear(int year) {
        this.year = year;
    }

    //declares a getter method which returns name
    public int getCapacity() {
        return capacity;
    }

    //declares a setter method which sets capacity
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
