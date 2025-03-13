package A6.Q1;

import static org.junit.Assert.assertArrayEquals;
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

    @Test
    public void getUnionTest() {
        assertArrayEquals(new IntSet(new int[]{12,43,53,109,24,89}).getElements(), IntSet.getUnion(obj2, obj1).getElements());
    }

    @Test
    public void getIntersectionTest() {
        assertArrayEquals(new IntSet(new int[]{43,53,24}).getElements(), IntSet.getIntersection(obj1, obj2).getElements());
    }

    @Test
    public void getDifferenceTest() {
        assertArrayEquals(new IntSet(new int[]{12,109,89}).getElements(), IntSet.getDifference(obj1, obj2).getElements());
    }

}
