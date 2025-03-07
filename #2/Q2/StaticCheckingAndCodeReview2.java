import java.util.ArrayList;
import java.util.Scanner;

class JobScheduler {
    // int[][] jobs = {{0,10}, {6,20}, {60,10}, {110,5}};
    ArrayList<ArrayList<Integer>> jobs = new ArrayList<ArrayList<Integer>>();

    /*
     * this function calculates the completion time of all the jobs and return them in an array 
     * completion time = arrival time + waiting time + burst time (OR) starting time + burst time
    */
    ArrayList<Integer> calculateCompletionTime() {
        ArrayList<Integer> completionTime = new ArrayList<>();
        try {
            int currentTime = 0;
            for(int index = 0; index<jobs.size(); index++) {
                int arrivalTime = jobs.get(index).get(0);
                int burstTime = jobs.get(index).get(1);
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

    /*
     * this function calculates the waiting time of all the jobs and return them in an array
     * waiting time = completion time - arrival time - burst time
    */
    ArrayList<Integer> calculateWaitingTime() {
        ArrayList<Integer> waitingTime = new ArrayList<>();
        try {
            ArrayList<Integer> completionTime = calculateCompletionTime();
            for(int index = 0; index<jobs.size(); index++) {
                int arrivalTime = jobs.get(index).get(0);
                int burstTime = jobs.get(index).get(1);
                int waitTime = completionTime.get(index) - arrivalTime - burstTime;
                waitingTime.add(waitTime);
            }
        } catch(Exception e) {
            System.out.println("Error in calculating waiting time: " + e.getMessage());
        }
        return waitingTime;
    }

    /*
     * this function calculates the turn around time of all the jobs and retuen them in an array
     * turn around time = completion time - arrival time
    */
    ArrayList<Integer> calculateTurnAroundTime() {
        ArrayList<Integer> turnAroundTime = new ArrayList<>();
        try {
            ArrayList<Integer> completionTIme = calculateCompletionTime();
            for(int index = 0; index<jobs.size(); index++) {
                int arrivalTime = jobs.get(index).get(0);
                int turnAround = completionTIme.get(index) - arrivalTime;
                turnAroundTime.add(turnAround);
            }
        } catch(Exception e) {
            System.out.println("Error in calculating turn around time: " + e.getMessage());
        }
        return turnAroundTime;
    }

    /*
     * this function calcultes the average waiting time of all the jobs
     */
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

    /*
     * this function calculates the maximum waiting time from all the jobs
    */
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
    /*
     * this function prints the array given in the argument
    */
    void printArray(ArrayList<Integer> arr) {
        try{
            if(arr.size() == 0){
                System.out.println("Array is empty!!");
                return;
            }
            for(int index = 0; index < arr.size(); index++) {
                System.out.println(arr.get(index));
            }
            System.out.println();
        } catch(Exception e) {
            System.out.println("Error while printing array: " + e.getMessage());
        }
    }

    /*
     * this function is used to add jobs into the ArrayList
    */
    void addJobs(ArrayList<ArrayList<Integer>> jobs, int num) {
        Scanner sc = new Scanner(System.in);
        try{
            for(int index=0; index<num; index++){
                System.out.println(jobs.size());
                System.out.println("Enter the arrival time for job " + (jobs.size() + 1) + ": ");
                int arrivalTime = sc.nextInt();
                System.out.println("Enter the burst time for job " + (jobs.size() + 1) + ": ");
                int burstTime = sc.nextInt();

                ArrayList<Integer> job = new ArrayList<>();
                job.add(arrivalTime);
                job.add(burstTime);

                jobs.add(job);
            }
            System.out.println("Jobs added successfully!!\n");
        } catch (Exception e) {
            System.out.println("Error occured while adding a job: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JobScheduler scheduler = new JobScheduler();
        StaticCheckingAndCodeReview2 obj = new StaticCheckingAndCodeReview2();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of jobs you want to add: ");
        int num = sc.nextInt();
        obj.addJobs(scheduler.jobs, num);

        while(true) {
            System.out.println("Enter a choice: \n1. Calculate Completion time\n2. Calculate Waiting time\n3. Calculate Turn Around time\n4. Calculate Average waiting time\n5. Find maximum waiting time\n6. Add more jobs\n0. Exit");
            int choice = sc.nextInt();

            if(choice == 0) {
                System.out.println("Exiting..........\n");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Completion time for all the jobs: ");
                    ArrayList<Integer> completion = scheduler.calculateCompletionTime();
                    obj.printArray(completion);
                    break;
                
                case 2:
                    System.out.println("Waiting time for all the jobs: ");
                    ArrayList<Integer> waiting = scheduler.calculateWaitingTime();
                    obj.printArray(waiting);
                    break;

                case 3:
                    System.out.println("Turn Around time for all the jobs: ");
                    ArrayList<Integer> turnAround = scheduler.calculateTurnAroundTime();
                    obj.printArray(turnAround);
                    break;

                case 4:
                    System.out.println("Average waiting time is: " + scheduler.calculateAverageWaitingTime() + "\n");
                    break;

                case 5:
                    System.out.println("Maximum waiting time is: " + scheduler.calculateMaximumWaitingTIme() + "\n");
                    break;

                case 6:
                    System.out.println("Enter the number of jobs you want to add: ");
                    num = sc.nextInt();
                    obj.addJobs(scheduler.jobs, num);
                    break;

                default:
                    System.out.println("Enter a valid choice!!\n");
                    break;
            }
        }
        sc.close();
    }
}
