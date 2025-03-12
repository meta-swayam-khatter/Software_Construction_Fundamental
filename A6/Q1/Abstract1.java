package A6.Q1;

import java.io.FileWriter;
import java.io.IOException;

final class IntSet {
    private boolean[] elementsPresent;
    private int maxValue = 1000;

    /**
     * this function logs errors in error.txt file
     * @param e exception
     */
    private static void logError(Exception e) {
        try(FileWriter fw = new FileWriter("error.txt", true)) {
            fw.write(e.getMessage() + "\n");
        } catch(IOException ioException) {
            System.out.println("Failed to log the error!!");
        }
    }

    IntSet(int[] arr) {
        elementsPresent = new boolean[maxValue+1];
        for(int index=0; index<arr.length; index++) {
            if(arr[index] >= 0 && arr[index] <= maxValue) {
                this.elementsPresent[arr[index]] = true;
            }
        }
    }

    void printSet() {
        for(int i=1; i<=maxValue; i++) {
            if(this.elementsPresent[i]) {
                System.out.print(i + ", ");
            }
        }
    }

    boolean isMember(int num) {
        try {
            if(num>1000 || num<=0) {
                throw new ArrayIndexOutOfBoundsException("The valid range is 1-1000!!");
            }
            if(this.elementsPresent[num]) {
                return true;
            }
            return false;
        } catch (Exception e) {
            logError(e);
            return false;
        }
    }

    int size() {
        try {
            int count=0;
            for(int index=1; index<=maxValue; index++) {
                if(this.elementsPresent[index]) {
                    count++;
                }
            }
            return count;
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }

    boolean isSubSet(IntSet subSet) {
        try {
            for(int index=1; index<=maxValue; index++) {
                if(subSet.elementsPresent[index] && !this.elementsPresent[index]) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            logError(e);
            return false;
        }
    }

    IntSet getComplement() {
        try {
            IntSet complementArr = new IntSet(new int[]{});
            for(int index=1; index<=maxValue; index++) {
                complementArr.elementsPresent[index] = !this.elementsPresent[index];
            }
            return complementArr;
        } catch (Exception e) {
            logError(e);
            return new IntSet(new int[]{});
        }
    }

    IntSet getUnion(IntSet set1, IntSet set2) {
        try {
            IntSet result = new IntSet(new int[]{});
            for(int index=1; index<=maxValue; index++) {
                if(set1.elementsPresent[index] || set2.elementsPresent[index]) {
                    result.elementsPresent[index] = true;
                }
            }
            return result;
        } catch (Exception e) {
            logError(e);
            return new IntSet(new int[]{});
        }
    }

    IntSet getIntersection(IntSet set1, IntSet set2) {
        try {
            IntSet result = new IntSet(new int[]{});
            for(int index=1; index<=maxValue; index++) {
                if(set1.elementsPresent[index] && set2.elementsPresent[index]) {
                    result.elementsPresent[index] = true;
                }
            }
            return result;
        } catch (Exception e) {
            logError(e);
            return new IntSet(new int[]{});
        }
    }

    IntSet getDifference(IntSet set1, IntSet set2) {
        try {
            IntSet result = new IntSet(new int[]{});
            for(int index=1; index<=maxValue; index++) {
                if(set1.elementsPresent[index] && !set2.elementsPresent[index]) {
                    result.elementsPresent[index] = true;
                }
            }
            return result;
        } catch (Exception e) {
            logError(e);
            return new IntSet(new int[]{});
        }
    }
}

public class Abstract1 {
    public static void main(String[] args) {
        IntSet obj1 = new IntSet(new int[]{2,45,55,565,24,66,78});
        IntSet obj2 = new IntSet(new int[]{45,24,78});

        IntSet unionArr = new IntSet(new int[]{});
        unionArr = unionArr.getUnion(obj1, obj2);

        unionArr.printSet();
    }
}
