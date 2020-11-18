//declares a package
package sugamkarki;

//declares a class ShipDemo which is the main class
public class ShipDemo {
    //    declares the main method
    public static void main(String[] args) {
        Ship ship=new Ship();
//        declares an object 'ship1' which inherits Ship class with the name as "Calicio Jack", year as 1988 and capacity as 2400 as the parameters
        Ship ship1 = new Ship("Calico Jack", 1998, 2400);
//      declares an object 'ship2' which inherits Ship class with the name as "Queen", year as 1945 and capacity as 4000 as the parameters
        Ship ship2 = new Ship("Queen", 1945, 4000);
        //        calls all the getter functions of ship2 and prints them
        System.out.println(ship.getName() + "\t\t" + ship.getCapacity() + "\t\t" + ship.getYear());
//        calls all the getter functions of ship1 and prints them
        System.out.println(ship1.getName() + "\t\t" + ship1.getCapacity() + "\t\t" + ship1.getYear());
        //        calls all the getter functions of ship2 and prints them
        System.out.println(ship2.getName() + "\t\t" + ship2.getCapacity() + "\t\t" + ship2.getYear());
    }
}
