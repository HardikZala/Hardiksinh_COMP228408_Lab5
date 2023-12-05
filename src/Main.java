import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);

        int threadCount = 4;

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            if (i % 2 == 0) {
                executorService.submit(new Producer(bankAccount));
            } else {
                executorService.submit(new Consumer(bankAccount));
            }
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            // Wait for all threads to finish
        }

        System.out.println("Closing balance $=" + bankAccount.getBalance());
    }
}