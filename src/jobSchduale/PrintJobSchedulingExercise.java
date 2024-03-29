package jobSchduale;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
public class PrintJobSchedulingExercise {
    private static final int NUM_PRINTERS = 2;
    private Semaphore printerSemaphore = new Semaphore(NUM_PRINTERS);
    private List<String> printJobs = new ArrayList<>();
    public static void main(String[] args) {
        PrintJobSchedulingExercise exercise = new
                PrintJobSchedulingExercise();
        // Create and start multiple printer threads
        for (int i = 1; i <= NUM_PRINTERS; i++) {
            Printer printer = exercise.new Printer(i);
            printer.start();
        }
        // Create and start multiple print job threads
        for (int i = 1; i <= 5; i++) {
            PrintJob printJob = exercise.new PrintJob("Job " + i);
            printJob.start();
        }
    }
    class PrintJob extends Thread {
        private String jobName;
        PrintJob(String jobName) {
            this.jobName = jobName;
        }
        @Override
        public void run() {
            try {
                System.out.println("Scheduling " + jobName + " for printing.");
                        printerSemaphore.acquire(); // Acquire a printer
                System.out.println("Printing " + jobName);
                Thread.sleep(1000); // Simulate printing
                printerSemaphore.release(); // Release the printer
                System.out.println(jobName + " has been printed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class Printer extends Thread {
        private int printerId;
        Printer(int printerId) {
            this.printerId = printerId;
        }
        @Override
        public void run() {
            System.out.println("Printer " + printerId + " is ready.");
        }
    }
}

