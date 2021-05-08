package code.MultiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ryan.zjf
 * @date 2021/05/08
 */
public class CountDownTest {
    public static void main(String[] args) {
        CountDownTest test = new CountDownTest();
        test.test1();
    }
    public void test1() {
        CountDownLatch countDownLatch = new CountDownLatch(7);
        ExecutorService es = Executors.newFixedThreadPool(20);
        for(int i = 0; i < 20; ++i) {
            es.execute(() -> {
                long prevValue = countDownLatch.getCount();
                countDownLatch.countDown();
                if (countDownLatch.getCount() != prevValue) {
                    System.out.println("Count Updated");
                }
            });
        }

        es.shutdown();
    }
}
