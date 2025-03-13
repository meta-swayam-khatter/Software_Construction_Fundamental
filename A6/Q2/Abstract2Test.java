package A6.Q2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Abstract2Test {
    Poly obj1 = new Poly(new int[][]{{1,1}, {3,2}, {5,3}});
    Poly obj2 = new Poly(new int[][]{{1,1}, {3,2}, {5,3}});

    @Test
    public void evaluateTest() {
        assertEquals(9, obj1.evaluate(1));
    }

    @Test
    public void degreeTest() {
        assertEquals(3, obj1.degree());
    }

    // @Test
    // public void addPolyTest() {
    //     assertEquals(new Poly(new int[][]{{2,1}, {6,2}, {10,3}}), Poly.addPoly(obj1, obj2));
    // }
}
