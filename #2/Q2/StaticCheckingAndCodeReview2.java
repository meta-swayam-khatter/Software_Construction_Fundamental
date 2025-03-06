import java.util.ArrayList;

class JobScheduler {
    int[][] jobs = {{0,10}, {6,20}, {60,10}, {110,5}};

    ArrayList<Integer> calculateCompletionTime() {
        ArrayList<Integer> completionTime = new ArrayList<>();
        try {
            int currentTime = 0;
            for(int index = 0; index<jobs.length; index++) {
                int arrivalTime = jobs[index][0];
                int burstTime = jobs[index][1];
                if(currentTime < arrivalTime) {
                    currentTime = arrivalTime;
                }
                currentTime += burstTime;
                completionTime.add(currentTime);
            }
        } catch(Exception e) {
            System.out.println("Error in calculating completion time: " + e.getMessage());
        }
        return completionTime;
    }

    ArrayList<Integer> calculateWaitingTime() {
        ArrayList<Integer> waitingTime = new ArrayList<>();
        try {
            ArrayList<Integer> completionTime = calculateCompletionTime();
            for(int index = 0; index<jobs.length; index++) {
                int arrivalTime = jobs[index][0];
                int burstTime = jobs[index][1];
                int waitTime = completionTime.get(index) - arrivalTime - burstTime;
                waitingTime.add(waitTime);
            }
        } catch(Exception e) {
            System.out.println("Error in calculating waiting time: " + e.getMessage());
        }
        return waitingTime;
    }

    ArrayList<Integer> calculateTurnAroundTime() {
        ArrayList<Integer> turnAroundTime = new ArrayList<>();
        try {
            ArrayList<Integer> completionTIme = calculateCompletionTime();
            for(int index = 0; index<jobs.length; index++) {
                int arrivalTime = jobs[index][0];
                int turnAround = completionTIme.get(index) - arrivalTime;
                turnAroundTime.add(turnAround);
            }
        } catch(Exception e) {
            System.out.println("Error in calculating turn around time: " + e.getMessage());
        }
        return turnAroundTime;
    }

    float calculateAverageWaitingTime() {
        float averageWaitingTime = 0;
        try {
            ArrayList<Integer> waitingTime = calculateWaitingTime();
            if(waitingTime.size() == 0){
                throw new ArithmeticException("No jobs to calculate average waiting time");
            }
            int sum = 0;
            for(int time : waitingTime) {
                sum += time;
            }
            averageWaitingTime = (float)sum/waitingTime.size();
        } catch(Exception e) {
            System.out.println("Error in calculating average waiting time: " + e.getMessage());
        }
        return averageWaitingTime;
    }

    float calculateMaximumWaitingTIme() {
        float maximumWaitingTime = 0;
        try {
            ArrayList<Integer> waitingTime = calculateWaitingTime();
            if(waitingTime.size() == 0){
                throw new ArithmeticException("No jobs to calculate average waiting time");
            }
            maximumWaitingTime = waitingTime.get(0);
            for(int time : waitingTime) {
                if(time > maximumWaitingTime) {
                    maximumWaitingTime = time;
                }
            }
        } catch(Exception e) {
            System.out.println("Error in calculating maximum waiting time: " + e.getMessage());
        }
        return maximumWaitingTime;
    }
}

public class StaticCheckingAndCodeReview2 {
    void printArray(ArrayList<Integer> arr) {
        try{
            if(arr.size() == 0){
                System.out.println("Array is empty!!");
                return;
            }
            for(int index = 0; index < arr.size(); index++) {
                System.out.println(arr.get(index));
            }
        } catch(Exception e) {
            System.out.println("Error while printing array: " + e.getMessage());
        }
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

        System.out.println("Average waiting time: " + scheduler.calculateAverageWaitingTime());

        System.out.println("Maximum waiting time: " + scheduler.calculateMaximumWaitingTIme());
    }
}
