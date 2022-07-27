import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // create an executor
        ExecutorService executor = Executors.newSingleThreadExecutor();

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            // submit tasks to your executor
            executor.submit(new PrimeLogger(num));
            executor.shutdown();
        }
    }
}

class PrimeLogger implements Runnable {
    private final int num;

    public PrimeLogger(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        if (num <= 1) {
            return;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return;
            }
        }
        System.out.println(num + " is prime!");

    }
}