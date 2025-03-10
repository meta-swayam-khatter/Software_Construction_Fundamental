import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestingAndJunit2Test {
    @Test
    public void numberOfClumpsTest() {
        Clumps obj = new Clumps();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(1);

        assertEquals(2, obj.numberOfClumps(arr));
    }
}
