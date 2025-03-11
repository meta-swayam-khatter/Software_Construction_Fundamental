import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Search {
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
     * this function finds the given element in the array using linear search
     * @param arr array taken as the user input
     * @param target element which we want to find in the array
     * @param index the starting index of the array (0 by default)
     * @return index of the element if we found it in the array, -1 otherwise
     */
    int linearSearch(int[] arr, int target, int index) {
        try {
            if(index == arr.length) {
                return -1;
            } else if(arr[index] == target) {
                return index;
            } else {
                return linearSearch(arr, target, index+1);
            }
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }

    /**
     * this funstion finds the given element in the array using binary search
     * @param arr array taken as the user input
     * @param target element which we want to find in the array
     * @param start the starting index of the array (0 by default)
     * @param end the ending index of the array (arr.length by default)
     * @return index of the element if we found it in the array, -1 otherwise 
     */
    int binarySearch(int[] arr, int target, int start, int end) {
        try {
            if(start == end && arr[start] != target) {
                return -1;
            }
            int mid = (start + end)/2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                return binarySearch(arr, target, start, mid);
            } else {
                return binarySearch(arr, target, mid, end);
            }
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }
}

public class Recursion2 {
    public static void main(String[] args) {
        Search obj = new Search();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choose the type of sorting you want to perform: \n1. Linear Search\n2. Binary Search\n0. Exit\n");
        int choice = sc.nextInt();
        System.out.println("Enter the number of elements in array: ");
        int num = sc.nextInt();
        int arr[] = new int[num];
        System.out.println("Enter the elements in the array: (Sorted for Binary Search)");
        for(int index=0; index<num; index++) {
            arr[index] = sc.nextInt();
        }
        System.out.println("Enter the element you want to search: ");
        int target = sc.nextInt();

        int result=0;

        switch (choice) {
            case 0:
                System.out.println("Exiting............\n");
                break;

            case 1:
                result = obj.linearSearch(arr, target, 0);
                break;
        
            case 2:
                result = obj.binarySearch(arr, target, 0, num);
                break;
        
            default:
                System.out.println("Enter a valid choice!!\n");
                break;
        }

        if(result == -1) {
            System.out.println("Element not present in the array!!\n");
        } else {
            System.out.println("In the array " + target + " is present at index " + result);
        }
        sc.close();
    }
}
