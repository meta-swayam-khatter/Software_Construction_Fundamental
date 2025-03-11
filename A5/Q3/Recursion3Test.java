package A5.Q3;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class Recursion3Test {
    NQueens obj = new NQueens();
    int n=4;
    int[][] arr = new int[n][n];

    @Test
    public void nQueensTest() {
        assertTrue(obj.nQueens(arr, 0, n));
    }
}
