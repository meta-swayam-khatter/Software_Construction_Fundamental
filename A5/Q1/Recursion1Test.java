import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class Recursion1Test {
    MathProblem obj = new MathProblem();

    @Test
    public void lcmTest() {
        assertEquals(40, obj.lcm(10, 8, 0));
    }

    @Test
    public void hcfTest() {
        assertEquals(2, obj.hcf(10, 8));
    }
}
