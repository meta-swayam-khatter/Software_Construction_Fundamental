import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestingAndJunit1Test {
    @Test
    public void largestMirrorSectionTest() {
        Mirror obj = new Mirror();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(2);
        arr.add(1);
        arr.add(9);
        arr.add(2);
        arr.add(1);

        assertEquals(5, obj.largestMirrorSection(arr));
    }
}
