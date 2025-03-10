import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class SplitArray {
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
    
    int split(ArrayList<Integer> arr) {
        try {
            int index1=0;
            int index2=arr.size()-1;
            int sum1=arr.get(index1);
            int sum2=arr.get(index2);
            while(index1<index2) {
                if(sum1 > sum2) {
                    index2--;
                    if(index1==index2) {
                        break;
                    }
                    sum2+=arr.get(index2);
                } else if(sum1 < sum2) {
                    index1++;
                    if(index1==index2) {
                        break;
                    }
                    sum1+=arr.get(index1);
                } else {
                    index1++;
                    if(index1==index2) {
                        break;
                    }
                    sum1+=arr.get(index1);
                }
            }
            if(sum1 == sum2) {
                return index2;
            }
            return -1;
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }
}

public class TestingAndJunit4 {
    public static void main(String[] args) {
        SplitArray obj = new SplitArray();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        System.out.print("Enter the number of elements in the array: ");
        int num = sc.nextInt();
        System.out.println("Enter the elements: ");

        for(int index=0; index<num; index++) {
            int value = sc.nextInt();
            arr.add(value);
        }

        if(obj.split(arr) == -1) {
            System.out.println("Can't Split the array!!\n");
        } else {
            System.out.println("Split the array from " + obj.split(arr) + " to get the equal sum!!");
        }
        sc.close();
    }    
}
