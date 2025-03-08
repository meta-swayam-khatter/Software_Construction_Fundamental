import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Marksheet {
    ArrayList<Integer> marks;

    /**
     * this function logs errors in error.txt file
     * @param e exception
     */
    private void logError(Exception e) {
        try(FileWriter fw = new FileWriter("error.txt", true)) {
            fw.write(e.getMessage() + "\n");
        } catch(IOException ioException) {
            System.out.println("Failed to log the error!!");
        }
    }
    
    /**
     * finds average marks of all the students
     * @return average marks rounded upto 2 decimal place
     */
    double averageMarks() {
        try {
            int sum=0;
            for(int index=0; index<marks.size(); index++) {
                sum += marks.get(index);
            }
            double average = sum/marks.size();
            return Math.round(average*100)/100;
        } catch(Exception e) {
            logError(e);
            return -1;
        }
    }

    /**
     * finds the maximum marks
     * @return maximum marks
     */
    int maximumMarks() {
        try {
            int max = marks.get(0);
            for(int index=1; index<marks.size(); index++) {
                if(marks.get(index) > max) {
                    max = marks.get(index);
                }
            }
            return max;
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }

    /**
     * finds the minimum marks
     * @return minimum marks
     */
    int minimumMarks() {
        try {
            int min = marks.get(0);
            for(int index=1; index<marks.size(); index++) {
                if(marks.get(index) < min) {
                    min = marks.get(index);
                }
            }
            return min;
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }

    /**
     * finds the percentage of students passed (marks >= 40)
     * @return passed percentage rounded upto 2 decimal place
     */
    double studentsPassed() {
        try {
            int passed=0;
            for(int index=0; index<marks.size(); index++) {
                if(marks.get(index) >= 40) {
                    passed++;
                }
            }
            float passedPercentage = (marks.size()/passed)*100;
            return Math.round(passedPercentage*100)/100;
        } catch (Exception e) {
            logError(e);
            return -1;
        }
    }
}

public class StringOperations2 {
    static Scanner sc = new Scanner(System.in);
    static Marksheet obj = new Marksheet();

    /**
     * adds the marks into the ArrayList
     * @param num number of students
     */
    static void setMarks(ArrayList<Integer> marks, int num) {
        try {
            for(int index=0; index<num; index++) {
                System.out.println("Enter the grade of student " + (index + 1) + " : ");
                int mark = sc.nextInt();
                marks.add(mark);
            }
        } catch(Exception e) {
            System.out.println("Error in adding marks!!");
        }
    }

    public static void main(String[] args) {
        setMarks(obj.marks, 5);
        obj.averageMarks();
        obj.maximumMarks();
        obj.minimumMarks();
        obj.studentsPassed();
    }
}
