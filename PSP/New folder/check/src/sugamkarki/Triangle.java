//declares package
package sugamkarki;
//imports scanner

import java.util.Scanner;

//declares class
public class Triangle {
    //    declares main method
    public static void main(String[] args) {
//        loops the program until commanded otherwise
        while (true) {
//            declares a char
            char choice;
//            creates objcet of scanner
            Scanner scan = new Scanner(System.in);
//            asks for three sides and stores them
            System.out.println("Enter Three sides(doubles)");
            double firstSide = scan.nextDouble();
            double secondSide = scan.nextDouble();
            double thirdSide = scan.nextDouble();
//            gets the boolean of the method while calling it
            boolean validityOfTriangle = checkTriangle(firstSide, secondSide, thirdSide);
//            only runs if the condition is true
            if (validityOfTriangle == true) {
//                gets the longest
                double longest = getLongest(firstSide, secondSide, thirdSide);
//                checks if the triangle is right angled
                boolean rightAngledTriangle = checkRightTriangle(firstSide, secondSide, thirdSide);
//              gets the type of triangle
                String type = checkTypeTriangle(firstSide, secondSide, thirdSide);
//                only if the triangle is right angled
                if (rightAngledTriangle) {
                    System.out.println("This is a right-angled " + type + " triangle. ");
                } else {
                    System.out.println("This is a " + type + " triangle.");
                }

            } else {
//                prints the statement
                System.out.println("Input is invalid. Triangle cannot be formed.");
            }
//            asks the user about running the program again
            System.out.println("Would you like to run the program again? (Y/N)");
            Scanner scan1 = new Scanner(System.in);
            choice = scan1.next().charAt(0);
//            breaks the program if the choice is "N"
            if (choice == 'N') {
                break;
            }
        }

    }

    //declares a method with three arguments
    private static String checkTypeTriangle(double s1, double s2, double s3) {
//        checks if the triangle is equilateral
        if (s1 == s2) {
            if (s1 == s3) {
                return "equilateral";
            }
        }
        //        checks if the triangle is isosceles
        if (s1 == s2 || s2 == s3 || s1 == s3) {
            return "isosceles";
        }
//        returns scalene
        return "scalene";
    }

    //declares a method with three arguments
    private static boolean checkRightTriangle(double s1, double s2, double s3) {
//        checks if the triangle is right angled
        if (s1 > s2 && s1 > s3) {
            if (s1 * s1 == ((s2 * s2) + (s3 * s3))) {
                return true;
            }
        }
        if (s2 > s1 && s2 > s3) {
            if (s2 * s2 == ((s1 * s1) + (s3 * s3))) {
                return true;
            }
        }
        if (s3 > s1 && s3 > s2) {
            if (s3 * s3 == ((s2 * s2) + (s1 * s1))) {
                return true;
            }
        }
//        returns false as the defaullt return
        return false;

    }

    //declares a method with three arguments
    public static double getLongest(double s1, double s2, double s3) {
//        returns the longest among three variables
        if (s1 > s2 && s1 > s3) {
            return s1;
        }
        if (s2 > s1 && s2 > s3) {
            return s2;
        }
        if (s3 > s1 && s3 > s2) {
            return s3;
        }
//        returns the first value as all are equal
        return s1;
    }
//declares a method with three arguments
    public static boolean checkTriangle(double s1, double s2, double s3) {
//        checks the validity of the triangle
        if (s1 + s2 > s3) {
            return true;
        }
//        returns false as the default return type
        return false;
    }
}
