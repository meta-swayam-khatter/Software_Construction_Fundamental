package A6.Q1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class Abstract1Test {
    IntSet obj1 = new IntSet(new int[]{12,43,53,109,24,89});
    IntSet obj2 = new IntSet(new int[]{43,53,24});

    @Test
    public void isMemberTest() {
        assertTrue(obj1.isMember(12));
    }

    @Test
    public void sizeTest() {
        assertEquals(6, obj1.size());
    }

    @Test
    public void isSubSetTest() {
        assertTrue(obj1.isSubSet(obj2));
    }

    // @Test
    // public void getUnionTest() {
    //     assertEquals(new int[]{12,45,53,109,24,89}, IntSet.getUnion(obj2, obj1));
    // }
}
