import java.util.ArrayList;

class JobScheduler {
    ArrayList<Integer> calculateCompletionTime() {
        ArrayList<Integer> completionTime = new ArrayList<>();
        return completionTime;
    }

    ArrayList<Integer> calculateWaitingTime() {
        ArrayList<Integer> waitingTime = new ArrayList<>();
        return waitingTime;
    }

    ArrayList<Integer> calculateTurnAroundTime() {
        ArrayList<Integer> turnAroundTime = new ArrayList<>();
        return turnAroundTime;
    }

    float calculateAverageWaitingTime() {
        float averageWaitingTime = 0;
        return averageWaitingTime;
    }

    float calculateMaximumWaitingTIme() {
        float maximumWaitingTime = 0;
        return maximumWaitingTime;
    }
}

public class StaticCheckingAndCodeReview2 {
    int[][] jobs = {{0,10}, {6,20}, {60,10}, {110,5}};

    void printArray(ArrayList<Integer> arr) {
        if(arr.size() == 0){
            System.out.println("Array is empty!!");
            return;
        }
        for(int index = 0; index < arr.size(); index++) {
            System.out.println(arr.get(index));
        }
        return;
    }

    public static void main(String[] args) {
        JobScheduler scheduler = new JobScheduler();
        StaticCheckingAndCodeReview2 obj = new StaticCheckingAndCodeReview2();
        ArrayList<Integer> completion = scheduler.calculateCompletionTime();
        ArrayList<Integer> waiting = scheduler.calculateWaitingTime();
        ArrayList<Integer> turnAround = scheduler.calculateTurnAroundTime();
        
        System.out.println("Completion time for each process: ");
        obj.printArray(completion);
        
        System.out.println("Waiting time for each process: ");
        obj.printArray(waiting);
        
        System.out.println("Turn Around time for each process: ");
        obj.printArray(turnAround);

        System.out.println("Average waiting time: ");

        System.out.println("Maximum waiting time: ");
    }
}
