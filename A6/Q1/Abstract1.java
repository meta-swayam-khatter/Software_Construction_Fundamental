package A6.Q1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

final class IntSet {
    private boolean[] elementsPresent;
    private static int maxValue = 1000;

    public boolean[] getElements() {
        return this.elementsPresent;
    }

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
     * Constructor
     * @param arr input array which will be converted to set
     */
    IntSet(int[] arr) {
        elementsPresent = new boolean[maxValue+1];
        for(int index=0; index<arr.length; index++) {
            if(arr[index] >= 0 && arr[index] <= maxValue) {
                this.elementsPresent[arr[index]] = true;
            }
        }
    }

    /**
     * this function prints the set
     */
    void printSet() {
        for(int i=1; i<=maxValue; i++) {
            if(this.elementsPresent[i]) {
                System.out.print(i + ", ");
            }
        }
    }

    /**
     * this function checks if a number is present in the set or not
     * @param num number which we want to check
     * @return true if present, false otherwise
     */
    boolean isMember(int num) {
        try {
            if(num>1000 || num<=0) {
                throw new ArrayIndexOutOfBoundsException("The valid range is 1-1000!!");
            }
            if(this.elementsPresent[num]) {
                return true;
            }
            return false;
        } catch (Exception e) {
            logError(e);
            return false;
        }
    }

    /**
     * this function finds the size of the set
     * @return size of the set
     */
    int size() {
        try {
            int count=0;
            for(int index=1; index<=maxValue; index++) {
                if(this.elementsPresent[index]) {
                    count++;
                }
            }
            return count;
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }

    /**
     * this function checks if the given set is a subset or not
     * @param subSet subset that we want to check
     * @return true if subSet is a subset, false otherwise
     */
    boolean isSubSet(IntSet subSet) {
        try {
            for(int index=1; index<=maxValue; index++) {
                if(subSet.elementsPresent[index] && !this.elementsPresent[index]) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            logError(e);
            return false;
        }
    }

    /**
     * this function finds the complement of a set (considering universal set to be 1-1000)
     * @return complement of a set
     */
    IntSet getComplement() {
        try {
            IntSet complementArr = new IntSet(new int[]{});
            for(int index=1; index<=maxValue; index++) {
                complementArr.elementsPresent[index] = !this.elementsPresent[index];
            }
            return complementArr;
        } catch (Exception e) {
            logError(e);
            return new IntSet(new int[]{});
        }
    }

    /**
     * this function finds the union of a two sets
     * @param set1 first set
     * @param set2 second set
     * @return union set
     */
    static IntSet getUnion(IntSet set1, IntSet set2) {
        try {
            IntSet result = new IntSet(new int[]{});
            for(int index=1; index<=maxValue; index++) {
                if(set1.elementsPresent[index] || set2.elementsPresent[index]) {
                    result.elementsPresent[index] = true;
                }
            }
            return result;
        } catch (Exception e) {
            logError(e);
            return new IntSet(new int[]{});
        }
    }

    /**
     * this function finds the intersention of two sets
     * @param set1 fisrt set
     * @param set2 second set
     * @return intersection set
     */
    static IntSet getIntersection(IntSet set1, IntSet set2) {
        try {
            IntSet result = new IntSet(new int[]{});
            for(int index=1; index<=maxValue; index++) {
                if(set1.elementsPresent[index] && set2.elementsPresent[index]) {
                    result.elementsPresent[index] = true;
                }
            }
            return result;
        } catch (Exception e) {
            logError(e);
            return new IntSet(new int[]{});
        }
    }

    /**
     * this function finds the difference of two sets
     * @param set1 first set
     * @param set2 second set
     * @return differnce of first and seconds set
     */
    static IntSet getDifference(IntSet set1, IntSet set2) {
        try {
            IntSet result = new IntSet(new int[]{});
            for(int index=1; index<=maxValue; index++) {
                if(set1.elementsPresent[index] && !set2.elementsPresent[index]) {
                    result.elementsPresent[index] = true;
                }
            }
            return result;
        } catch (Exception e) {
            logError(e);
            return new IntSet(new int[]{});
        }
    }
}

public class Abstract1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the first set: ");
        int num = sc.nextInt();
        
        System.out.println("Enter the elements of set: ");
        int[] arr = new int[num];
        for(int index=0; index<num; index++) {
            int value = sc.nextInt();
            arr[index] = value;
        }
        IntSet obj1 = new IntSet(arr);

        while(true) {
            System.out.println("\nEnter your choice: \n1. Check is member\n2. Find size\n3. check is subset\n4. Get union\n5. Get intersection\n6. Get complement\n7. Get difference\n 0. Exit");
            int choice = sc.nextInt();

            if(choice == 0) {
                System.out.println("Exiting........\n");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter the element you want to check is member: ");
                    int elem = sc.nextInt();
                    if(obj1.isMember(elem)) {
                        System.out.println(elem + " is a member of the Set\n");
                    } else {
                        System.out.println(elem + " is not a member of the Set\n");
                    }
                    break;

                case 2:
                    System.out.println("Size of the set is: " + obj1.size() + "\n");
                    break;

                case 3:
                    System.out.println("Enter the number of elements in the second set: ");
                    num = sc.nextInt();
                    
                    System.out.println("Enter the elements of the second set: ");
                    arr = new int[num];
                    for(int index=0; index<num; index++) {
                        int value = sc.nextInt();
                        arr[index] = value;
                    }
                    IntSet obj2 = new IntSet(arr);
                    if(obj1.isSubSet(obj2)) {
                        System.out.println("This set is a subset of the first set\n");
                    } else {
                        System.out.println("This set is not a subset of first set\n");
                    }
                    break;

                case 4:
                    System.out.println("Enter the number of elements in the second set: ");
                    num = sc.nextInt();
                    
                    System.out.println("Enter the elements of the second set: ");
                    arr = new int[num];
                    for(int index=0; index<num; index++) {
                        int value = sc.nextInt();
                        arr[index] = value;
                    }
                    obj2 = new IntSet(arr);
                    IntSet union = IntSet.getUnion(obj1, obj2);
                    System.out.println("The union set is: ");
                    union.printSet();
                    break;

                case 5:
                    System.out.println("Enter the number of elements in the second set: ");
                    num = sc.nextInt();
                    
                    System.out.println("Enter the elements of the second set: ");
                    arr = new int[num];
                    for(int index=0; index<num; index++) {
                        int value = sc.nextInt();
                        arr[index] = value;
                    }
                    obj2 = new IntSet(arr);
                    IntSet intersection = IntSet.getIntersection(obj1, obj2);
                    System.out.println("The intersection set is: ");
                    intersection.printSet();
                    break;

                case 6:
                    IntSet complement = obj1.getComplement();
                    System.out.println("The complement set is: ");
                    complement.printSet();
                    break;

                case 7:
                    System.out.println("Enter the number of elements in the second set: ");
                    num = sc.nextInt();
                    
                    System.out.println("Enter the elements of the second set: ");
                    arr = new int[num];
                    for(int index=0; index<num; index++) {
                        int value = sc.nextInt();
                        arr[index] = value;
                    }
                    obj2 = new IntSet(arr);
                    IntSet difference = IntSet.getDifference(obj1, obj2);
                    System.out.println("The difference of these two sets is: ");
                    difference.printSet();
                    break;
                
                default:
                    System.out.println("Enter a valid choice!!\n");
                    break;
            }
        }
        sc.close();
    }
}
