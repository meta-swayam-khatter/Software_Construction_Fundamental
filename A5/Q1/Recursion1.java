import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class MathProblem {
    /**
     * this function logs errors in error.txt file
     * @param e exception
     */
    private static void logError(Exception e) {
        try(FileWriter fw = new FileWriter("error.txt", true)) {
            fw.write(e.getMessage() + "\n");
        } catch(IOException ioException) {
            System.out.println("Failed to log the error!!");
        }
    }

    /**
     * finds the lcm of 2 numbers
     * @param x user input1 
     * @param y user input2
     * @param temp temp variable to compute the LCM (0 by default)
     * @return lcm of x and y
     */
    int lcm(int x, int y, int temp) {
        if(x<-0 || y<=0) {
            throw new ArithmeticException("Only positive integers allowed!!\n");
        }
        try {
            if(x>y) {
                temp += x;
            } else if(x<y) {
                temp +=y;
            } else {
                return x;
            }

            if(temp%x == 0 && temp%y == 0) {
                return temp;
            } else {
                return lcm(x, y, temp);
            }
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }

    /**
     * finds the hcf of 2 numbers
     * @param x user input1
     * @param y user input2
     * @return hcf of x and y
     */
    int hcf(int x, int y) {
        try{
            if(y == 0) {return x;}
            else {return hcf(y, x%y);}
        } catch(Exception e) {
            logError(e);
            return -1;
        }
    }
}

public class Recursion1 {
    public static void main(String[] args) {
        MathProblem obj = new MathProblem();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of x: ");
        int x = sc.nextInt();
        System.out.println("Enter the value of y: ");
        int y = sc.nextInt();

        System.out.println("LCM of " + x + " and " + y + " is: " + obj.lcm(x, y, 0));
        System.out.println("HCF of " + x + " and " + y + " is: " + obj.hcf(x, y));
        
        sc.close();
    }
}
