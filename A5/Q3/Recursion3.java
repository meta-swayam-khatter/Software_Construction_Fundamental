package A5.Q3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class NQueens {
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
     * this function checks if we can place n queens on a nXn board
     * @param board nXn array which represents the chess board
     * @param row the starting row of the board (0 by default)
     * @param n no of queens and the dimensions of the board
     * @return true if n queens can be placed on a nXn board
     */
    boolean nQueens(int[][] board, int row, int n) {
        try {
            if(row>=n) return true;
            for(int col=0; col<n; col++) {
                if(isSafe(board, row, col, n)) {
                    board[row][col] = 1;
                    if(nQueens(board, row+1, n)) return true;
                    board[row][col] = 0;
                }
            }
            return false;
        } catch (Exception e) {
            logError(e);
            return false;
        }
    }

    /**
     * this function checks if the position we want to place the the queen is safe or not
     * @param board nXn array which represents the chess board
     * @param row row which we want to check
     * @param col colums we want to check
     * @param n no of queens and the dimensions of the board
     * @return true if the position [row][col] is safe to palce a queen or not
     */
    boolean isSafe(int[][] board, int row, int col, int n) {
        try {
            for(int index=0; index<row; index++) {
                if(board[index][col] == 1) return false;
            }
            for(int index1=row, index2=col; index1>=0 && index2>=0; index1--, index2--) {
                if(board[index1][index2] == 1) return false;
            }
            for(int index1=row, index2=col; index1>=0 && index2<n; index1--, index2++) {
                if(board[index1][index2] == 1) return false;
            }
            return true;
        } catch (Exception e) {
            logError(e);
            return false;
        }
    }
}

public class Recursion3 {
    public static void main(String[] args) {
        NQueens obj = new NQueens();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n: ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];
        if(obj.nQueens(board, 0, n)) {
            for(int index1=0; index1<n; index1++) {
                for(int index2=0; index2<n; index2++) {
                    System.out.print(board[index1][index2] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Can't place " + n + " Queens on a " + n + " X " + n + " board.");
        }
        sc.close();
    }
}
