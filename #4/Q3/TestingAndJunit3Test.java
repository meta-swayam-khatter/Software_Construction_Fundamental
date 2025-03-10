import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestingAndJunit3Test {

    static boolean isEqualArr(ArrayList<Integer> a, ArrayList<Integer> b){
        for(int i:a) System.out.println(i);
        System.out.println();
        for(int i:b) System.out.println(i);
        if(a.size()!=b.size()) return false;
        for(int i=0; i<a.size(); i++){
            if(a.get(i)!=b.get(i)) return false;
        }
        return true;
    }

    @Test
    public void fixXYTest() {
        FixXY obj = new FixXY();
        int[] arr = new int[]{5,4,9,4,9,5};

        int[] result = new int[]{9,4,5,4,5,9};
        
        assertArrayEquals(result, obj.fixXY(arr, 4, 5));
    }
}
