import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class Recursion2Test {
    Search obj = new Search();
    int[] arr = {3,5,11,27,30,45};

    @Test
    public void linearSearchTest() {
        assertEquals(2, obj.linearSearch(arr, 11, 0));
    }

    @Test
    public void binarySearchTest() {
        assertEquals(3, obj.binarySearch(arr, 27, 0, arr.length));
    }
}
