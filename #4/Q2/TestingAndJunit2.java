import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Clumps {
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
     * this function returns the number of clumps present in the array
     * @param arr input array
     * @return number of clumps
     */
    int numberOfClumps(ArrayList<Integer> arr) {
        try {
            if(arr.size() == 0) {
                throw new AssertionError("Array is empty!!\n");
            }
            int num=0;
            int compare=arr.get(0);
            boolean clump=false;
            for(int index=1; index<arr.size(); index++) {
                if(arr.get(index) != compare && clump == true) {
                    num++;
                    clump = false;
                } else if(arr.get(index) == compare && clump == false){
                    clump=true;
                }
                compare=arr.get(index);
            }
            if(clump == true) {
                num++;
            }
            return num;
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }
}

public class TestingAndJunit2 {
    public static void main(String[] args) {
        Clumps obj = new Clumps();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        System.out.print("Enter the length of array: ");
        int length = sc.nextInt();
        System.out.println("Enter the elements: ");
        for(int index=0; index<length; index++) {
            int value = sc.nextInt();
            arr.add(value);
        }

        System.out.println("Number of clumps in the given array is: " + obj.numberOfClumps(arr));
        sc.close();
    }
}