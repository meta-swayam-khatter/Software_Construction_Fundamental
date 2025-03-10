import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestingAndJunit4Test {
    @Test
    public void splitTest() {
        SplitArray obj = new SplitArray();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(1);

        assertEquals(3, obj.split(arr));
    }
}
