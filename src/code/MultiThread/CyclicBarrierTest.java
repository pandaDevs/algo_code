package code.MultiThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ryan.zjf
 * @date 2021/05/08
 */
public class CyclicBarrierTest {

    private CyclicBarrier cyclicBarrier;
    private List<List<Integer>> partialResults = Collections.synchronizedList(new ArrayList<>());
    private Random random = new Random();
    private int NUM_WORKERS;
    private int NUM_PARTIAL_RESULTS;

    public static void main(String[] args) {
        CyclicBarrierTest test = new CyclicBarrierTest();
        test.runSimulation(5,3);
    }

    public void test2() {
        CyclicBarrier cb = new CyclicBarrier(7);
        ExecutorService es = Executors.newFixedThreadPool(20);
        for(int i = 0; i < 20; ++i) {
            es.execute(() -> {
                try {
                    if (cb.getNumberWaiting() <= 0) {
                        System.out.println("Count Updated");
                    }

                    cb.await();
                    System.out.println("broken barrier");
                } catch (InterruptedException | BrokenBarrierException e) {

                }
            });
        }

        es.shutdown();
    }

    public void runSimulation(int numWorkers, int numberOfPartialResults) {
        NUM_WORKERS = numWorkers;
        NUM_PARTIAL_RESULTS = numberOfPartialResults;
        cyclicBarrier = new CyclicBarrier(NUM_WORKERS, new AggregatorThread());

        System.out.println("Spawning " + NUM_WORKERS
            + " worker threads to compute "
            + NUM_PARTIAL_RESULTS + " partial results each");

        for(int i = 0; i < NUM_WORKERS; ++i) {
            Thread t = new Thread(new NumberCruncherThread());
            t.setName("Thread-" + i);
            t.start();
        }
    }

    class NumberCruncherThread implements Runnable {

        @Override
        public void run() {
            String thisThreadName = Thread.currentThread().getName();
            List<Integer> partialResult = new ArrayList<>();

            for(int i = 0; i < NUM_PARTIAL_RESULTS; ++i) {
                int num = random.nextInt(10);
                System.out.println(thisThreadName + ": Cruncher some numbers! Final result - " + num);
                partialResult.add(num);
            }

            partialResults.add(partialResult);
            try {
                System.out.println(thisThreadName
                    + " waiting for others to reach barrier.");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                // ...
            }
        }
    }

    class AggregatorThread implements Runnable {

        @Override
        public void run() {
            String thisThreadName = Thread.currentThread().getName();

            System.out.println(
                thisThreadName + ": Computing sum of " + NUM_WORKERS
                    + " workers, having " + NUM_PARTIAL_RESULTS + " results each.");
            int sum = 0;

            for (List<Integer> threadResult : partialResults) {
                System.out.print("Adding ");
                for (Integer partialResult : threadResult) {
                    System.out.print(partialResult+" ");
                    sum += partialResult;
                }
                System.out.println();
            }
            System.out.println(thisThreadName + ": Final result = " + sum);
        }
    }
}
