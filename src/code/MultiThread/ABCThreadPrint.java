package code.MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.sound.midi.Track;

public class ABCThreadPrint {
    public static void main(String[] args) {
        final AlternateDemo demo = new AlternateDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; ++i) {
                    demo.loopA();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; ++i) {
                    demo.loopB();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; ++i) {
                    demo.loopC();
                    System.out.println("-----------------------------------");
                }
            }
        }, "C").start();
    }
}

class AlternateDemo {
    private int number = 1; // 当前正在执行的线程标记

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA() {
        lock.lock();
        try{
            if(number != 1) {
                condition1.await();;
            }
            System.out.println(Thread.currentThread().getName());
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB() {
        lock.lock();
        try{
            if(number != 2 ) {
                condition2.await();
            }
            number = 3;
            System.out.println(Thread.currentThread().getName());
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC() {
        lock.lock();
        try{
            if(number != 3) {
                condition3.await();
            }

            number = 1;
            System.out.println(Thread.currentThread().getName());
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
