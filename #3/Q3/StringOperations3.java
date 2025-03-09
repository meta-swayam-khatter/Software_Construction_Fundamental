import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Area {
    /**
     * this function logs errors in error.txt file
     * @param e exception
     */
    private void logError(Exception e) {
        try(FileWriter fw = new FileWriter("error.txt", true)) {
            fw.write(e.getMessage() + "\n");
        } catch(IOException ioException) {
            System.out.println("Failed to log the error!!");
        }
    }
    
    /**
     * finds the area of a triangle
     * @param width takes width of triangle as an input Double
     * @param height takes height of the triangle as an input Double
     * @return calculated area of triangle Double
     */
    double triangle(double width, double height) {
        try {
            return (0.5 * width * height);
        } catch(Exception e) {
            logError(e);
            return -1;
        }
    }

    /**
     * finds the area of a rectangle
     * @param width takes width of rectangle as an input Double
     * @param height takes height of triangle as an input Double
     * @return calculted area of rectangle Double
     */
    double rectangle(double width, double height) {
        try {
            return (width * height);
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }

    /**
     * finde the area of a square
     * @param width takes width of square as an input Double
     * @return calculated area of square Double
     */
    double square(double width) {
        try {
            return (Math.pow(width, 2));
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }

    /**
     * finds the area of a circle
     * @param radius takes radius of circle as an input Double
     * @return calculated area of circle Double
     */
    double circle(double radius) {
        try {
            double pi = 3.14;
            return (pi * Math.pow(radius, 2));
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }
}

public class StringOperations3 {
    static Scanner sc = new Scanner(System.in);
    static Area obj = new Area();
    static double arg1=0;
    static double arg2=0;

    public static void main(String[] args) {
        while(true) {
            System.out.println("Enter your choice: \n1. Area of Triangle\n2. Area of Rectangle\n3. Area of Square\n4. Area of Circle\n0. Exit");
            int choice = sc.nextInt();

            if(choice == 0) {
                System.out.println("Exiting...........\n");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the width of the triangle: ");
                    arg1 = sc.nextDouble();
                    System.out.print("Enter the height of the triangle: ");
                    arg2 = sc.nextDouble();

                    System.out.println("\nArea of the Traingle is: " + obj.triangle(arg1, arg2) + "\n");
                    break;
            
                case 2:
                    System.out.print("Enter the width of the rectangle: ");
                    arg1 = sc.nextDouble();
                    System.out.print("Enter the height of the rectangle: ");
                    arg2 = sc.nextDouble();

                    System.out.println("\nArea of the Rectangle is: " + obj.rectangle(arg1, arg2) + "\n");
                    break;

                case 3:
                    System.out.print("Enter the width of the square: ");
                    arg1 = sc.nextDouble();

                    System.out.println("\nArea of the Square is: " + obj.square(arg1) + "\n");
                    break;

                case 4:
                    System.out.print("Enter the radius of the circle: ");
                    arg1 = sc.nextDouble();

                    System.out.println("\nArea od the Circle is: " + obj.circle(arg1) + "\n");
                    break;

                default:
                    System.out.println("Enter a valid choice!!\n");
                    break;
            }
        }
    }
}
