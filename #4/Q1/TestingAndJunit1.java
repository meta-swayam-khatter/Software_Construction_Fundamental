import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Mirror {
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
     * this functio finds the largest mirror section in an array
     * @param arr input array from the user
     * @return int value of the length of largest mirror section
     */
    int largestMirrorSection(ArrayList<Integer> arr) {
        try {
            if(arr.size() == 0) {
                throw new AssertionError("Array is empty!!\n");
            }
            int max=0;
            int mainIndex=0;
            int index1=0;
            int index2=arr.size()-1;
            while(index1<arr.size()) {
                int tempMax=0;
                while(index2>=0) {
                    if(arr.get(index1) == arr.get(index2)) {
                        tempMax++;
                        if(index1 != arr.size()-1){
                            index1++;
                        }
                        index2--;
                    } else {
                        index1=mainIndex;
                        if(tempMax == 0) {
                            index2--;
                        }
                        if(tempMax > max) {
                            max = tempMax;
                        }
                        tempMax=0;
                    }
                }
                if(tempMax > max) {
                    max = tempMax;
                }
                mainIndex++;
                index1=mainIndex;
                index2=arr.size()-1;
                if(mainIndex == arr.size()){
                    break;
                }
            }
            return max;
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }
}

public class TestingAndJunit1 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Mirror obj = new Mirror();
        System.out.print("Enter the number of elements in array: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int index=0; index<num; index++) {
            int value = sc.nextInt();
            arr.add(value);
        }

        System.out.println("Largest mirror section in this array is: " + obj.largestMirrorSection(arr));
        sc.close();
    }   
}
