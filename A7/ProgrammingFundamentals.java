package A7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class SparceMatrix {
    private final int rows;
    private final int columns;
    private final List<int[]> elements;

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

    SparceMatrix(int rows, int columns, List<int[]> elements) {
        this.rows = rows;
        this.columns = columns;
        this.elements = List.copyOf(elements);
    }

    public SparceMatrix transpose() {
        try {
            List<int[]> transposeMatrix = new ArrayList<>();
            for(int[] element : elements) {
                transposeMatrix.add(new int[]{element[1], element[0], element[2]});
            }
            return new SparceMatrix(columns, rows, transposeMatrix);
        } catch (Exception e) {
            logError(e);
            return new SparceMatrix(rows, columns, elements);
        }
    }

    public boolean isSymetric() {
        try {
            if(rows != columns) return false;
            for(int[] element : elements) {
                boolean found = false;
                for(int[] e : elements) {
                    if(e[0] == element[1] && e[1] == element[0] && e[2] == element[2]) {
                        found = true;
                        break;
                    }
                }
                if(!found) return false;
            }
            return true;
        } catch (Exception e) {
            logError(e);
            return false;
        }
    }

    public SparceMatrix add(SparceMatrix matrix) {
        try {
            if(this.rows != matrix.rows || this.columns != matrix.columns) {
                throw new IllegalArgumentException("Dimensions mismatch!!");
            }
            Map<String, Integer> sumMap = new HashMap<>();
            for(int[] element : elements) {
                sumMap.put(element[0] + ", " + element[1], element[2]);
            }
            System.out.println("First.................");
            for(Map.Entry<String, Integer> entry : sumMap.entrySet()) {
                System.out.println("String: " + entry.getKey() + "  Value: " + entry.getValue());
            }
            for(int[] otherElement : matrix.elements) {
                sumMap.put(otherElement[0] + ", " + otherElement[1], sumMap.getOrDefault(otherElement[0] + ", " + otherElement[1], 0) + otherElement[2]);
                // sumMap.merge(otherElement[0] + ", " + otherElement[1], otherElement[2], Integer::sum);
            }
            System.out.println("Second.................");
            for(Map.Entry<String, Integer> entry : sumMap.entrySet()) {
                System.out.println("String: " + entry.getKey() + "  Value: " + entry.getValue());
            }
            List<int[]> result = new ArrayList<>();
            for(Map.Entry<String, Integer> entry : sumMap.entrySet()) {
                String[] key = entry.getKey().split(", ");
                result.add(new int[]{Integer.parseInt(key[0]), Integer.parseInt(key[1]), entry.getValue()});
            }
            System.out.println("Third result.................");
            for(int[] res : result) {
                for(int r : res) {
                    System.out.print(r + " ");
                }
                System.out.println();
            }
            return new SparceMatrix(rows, columns, result);
        } catch (Exception e) {
            logError(e);
            throw e;
        }
    }

    public SparceMatrix multiply(SparceMatrix matrix) {
        try {
            if(this.columns != matrix.rows) {
                throw new IllegalArgumentException("Dimensions mismatch!!");
            }
            Map<String, Integer> product = new HashMap<>();
            for(int[] a : this.elements) {
                for(int[] b : matrix.elements) {
                    if(a[1] == b[0]) {
                        String key = a[0] + ", " + b[1];
                        product.merge(key, a[2]*b[2], Integer::sum);
                    }
                }
            }
            List<int[]> result = new ArrayList<>();
            for(Map.Entry<String, Integer> entry : product.entrySet()) {
                String[] key = entry.getKey().split(", ");
                result.add(new int[]{Integer.parseInt(key[0]), Integer.parseInt(key[1]), entry.getValue()});
            }
            return new SparceMatrix(rows, columns, result);
        } catch (Exception e) {
            logError(e);
            return new SparceMatrix(rows, columns, elements);
        }
    }

    public static void printSparce(SparceMatrix matrix) {
        try {
            int[][] array = new int[matrix.rows][matrix.columns];
    
            for(int[] element : matrix.elements) {
                array[element[0]][element[1]] = element[2];
            }
    
            for(int index1=0; index1<array.length; index1++) {
                for(int index2=0; index2<array[0].length; index2++) {
                    System.out.print(array[index1][index2] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            logError(e);
        }
    }
}

public class ProgrammingFundamentals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // List<int[]> elements = new ArrayList<>();

        // System.out.print("Enter the number of Rows: ");
        // int row = sc.nextInt();
        // System.out.print("Enter the number of Columns: ");
        // int column = sc.nextInt();

        // System.out.print("Enter the number of Non-Zero elements in the matrix: ");
        // int num = sc.nextInt();
        // for(int index = 0; index<num; index++) {
        //     System.out.print("Enter the row of element " + (index+1) + ": ");
        //     int r = sc.nextInt();
        //     System.out.print("Enter the column of element " + (index+1) + ": ");
        //     int c = sc.nextInt();
        //     System.out.print("Enter the value of element " + (index+1) + ": ");
        //     int val = sc.nextInt();

        //     elements.add(new int[]{r,c,val});
        // }

        // SparceMatrix obj1 = new SparceMatrix(row, column, elements);
        List<int[]> ls = new ArrayList<>();
        ls.add(new int[]{0,4,9});
        ls.add(new int[]{1,1,8});
        ls.add(new int[]{2,0,4});
        ls.add(new int[]{2,3,2});
        ls.add(new int[]{3,5,5});
        ls.add(new int[]{4,2,2});
        SparceMatrix obj1 = new SparceMatrix(5, 6, ls);
        SparceMatrix obj2 = new SparceMatrix(5, 6, ls);

        while(true) {
            System.out.println("Enter your Choice: \n1. Transpose matrix\n2. Check if matrix is symetric\n3. Add matrix\n4. Multiply matrix\n0. Exit");
            int choice = sc.nextInt();

            if(choice == 0) {
                System.out.println("Exiting..........\n");
                break;
            }

            switch(choice) {
                case 1:
                    SparceMatrix.printSparce(obj1.transpose());
                    break;

                case 2:
                    if(obj1.isSymetric()) {
                        System.out.println("This Sparce Matrix is Symetric!!\n");
                    } else {
                        System.out.println("This Sparce matrix is not Symetric!!\n");
                    }
                    break;

                case 3:
                    // System.out.print("Enter the number of Rows: ");
                    // row = sc.nextInt();
                    // System.out.print("Enter the number of Columns: ");
                    // column = sc.nextInt();
            
                    // System.out.print("Enter the number of Non-Zero elements in the matrix: ");
                    // num = sc.nextInt();
                    // for(int index = 0; index<num; index++) {
                    //     System.out.print("Enter the row of element " + (index+1) + ": ");
                    //     int r = sc.nextInt();
                    //     System.out.print("Enter the column of element " + (index+1) + ": ");
                    //     int c = sc.nextInt();
                    //     System.out.print("Enter the value of element " + (index+1) + ": ");
                    //     int val = sc.nextInt();
            
                    //     elements.add(new int[]{r,c,val});
                    // }
            
                    // SparceMatrix obj2 = new SparceMatrix(row, column, elements);

                    SparceMatrix.printSparce(obj2);
                    SparceMatrix result = obj1.add(obj2);
                    SparceMatrix.printSparce(result);
                    break;

                case 4:
                    // System.out.print("Enter the number of Rows: ");
                    // row = sc.nextInt();
                    // System.out.print("Enter the number of Columns: ");
                    // column = sc.nextInt();
            
                    // System.out.print("Enter the number of Non-Zero elements in the matrix: ");
                    // num = sc.nextInt();
                    // for(int index = 0; index<num; index++) {
                    //     System.out.print("Enter the row of element " + (index+1) + ": ");
                    //     int r = sc.nextInt();
                    //     System.out.print("Enter the column of element " + (index+1) + ": ");
                    //     int c = sc.nextInt();
                    //     System.out.print("Enter the value of element " + (index+1) + ": ");
                    //     int val = sc.nextInt();
            
                    //     elements.add(new int[]{r,c,val});
                    // }
            
                    // obj2 = new SparceMatrix(row, column, elements);

                    SparceMatrix.printSparce(obj1);
                    result = obj1.multiply(obj1);
                    SparceMatrix.printSparce(result);
                    break;
                    
                default:
                    System.out.println("Enter a valid choice!!\n");
                    break;
            }
        }
        sc.close();
    }
}
