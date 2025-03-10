import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class FixXY {
    /**
     * this function logs errors in error.txt file
     * 
     * @param e exception
     */
    private static void logError(Exception e) {
        try (FileWriter fw = new FileWriter("error.txt", true)) {
            fw.write(e.getMessage() + "\n");
        } catch (IOException ioException) {
            System.out.println("Failed to log the error!!");
        }
    }

    /**
     * this function fix the input array accoring to the condition (using BRUTE FORCE)
     * @param arr input array which needs to be fixed
     * @param X value of X user input
     * @param Y value of Y user input
     * @return fixed array
     */
    ArrayList<Integer> fix(ArrayList<Integer> arr, int X, int Y) {
        try {
            if (arr.size() == 0) {
                throw new AssertionError("Array is Empty!!\n");
            }

            int xIndex = -1;
            int xCount = 0;
            int yIndex = -1;
            int yCount = 0;

            for (int index = 0; index < arr.size(); index++) {
                if(arr.get(index) == X) {
                    xCount++;
                } else if(arr.get(index) == Y) {
                    yCount++;
                }
            }

            if(xCount != yCount) {
                throw new AssertionError("Count of X and Y are not same!!\n");
            }

            for (int index1 = 0; index1 < arr.size(); index1++) {
                if (arr.get(index1) == X) {
                    xCount++;
                    if (index1 == arr.size() - 1) {
                        throw new AssertionError("X comes at the end of the array!!\n");
                    }
                    if (arr.get(index1 + 1) == X) {
                        throw new AssertionError("There are Two adjacent values of X!!\n");
                    }
                    if (arr.get(index1 + 1) == Y) {
                        continue;
                    }
                    xIndex = index1;
                    for(int index2=0; index2<arr.size(); index2++) {
                        if(arr.get(index2) == Y) {
                            if(index2 != 0 && arr.get(index2-1) == X) {
                                continue;
                            }
                            yIndex=index2;
                            Collections.swap(arr, xIndex+1, yIndex);
                            break;
                        }
                    }
                } else {
                    continue;
                }
            }
            return arr;
        } catch (Exception e) {
            logError(e);
            return new ArrayList<>();
        }
    }

    /**
     * this function fix the input array accoring to the condition (using QUEUE)
     * @param arr input array which needs to be fixed
     * @param X value of X user input
     * @param Y value of Y user input
     * @return fixed array
     */
    int[] fixXY(int[] arr, int X, int Y) {
        try {
            if(arr.length == 0) {
                throw new AssertionError("Array is Empty!!\n");
            }

            Queue<Integer> q = new LinkedList<>();
            int xCount=0;
            int yCount=0;

            for(int index=0; index<arr.length; index++) {
                if(arr[index] == X) {
                    if(index == arr.length) {
                        throw new AssertionError("X occurs at the last index of array!!\n");
                    }
                    if(arr[index+1] == X) {
                        throw new AssertionError("There are two adjecent values of X!!\n");
                    }
                    xCount++;
                } else if(arr[index] == Y) {
                    yCount++;
                    if(index == 0) {
                        q.add(index);
                    } else if(arr[index-1] != X) {
                        q.add(index);
                    }
                }
            }

            if(xCount != yCount) {
                throw new AssertionError("Count of X and Y are not equal!!\n");
            }

            for(int index1=0; index1<arr.length; index1++) {
                if(arr[index1] == X && arr[index1+1] != Y) {
                    int i = arr[index1+1];
                    arr[index1+1] = arr[q.peek()];
                    arr[q.peek()] = i;
                    q.remove();
                }
            }

            return arr;
        } catch (Exception e) {
            logError(e);
            return new int[]{};
        }
    }
}


public class TestingAndJunit3 {
    public static void main(String[] args) {
        int[] arr = new int[]{};
        Scanner sc = new Scanner(System.in);
        FixXY obj = new FixXY();

        System.out.print("Enter the number of elements in array: ");
        int num = sc.nextInt();
        System.out.println("Enter the elements of array: ");

        for(int index=0; index<num; index++) {
            int value = sc.nextInt();
            arr[index] = value;
        }

        System.out.print("Enter the value of X: ");
        int X = sc.nextInt();
        System.out.print("Enter the value of Y: ");
        int Y = sc.nextInt();

        int[] result = obj.fixXY(arr, X, Y);

        System.out.println("Resultant array is: ");
        for(int val : result) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
