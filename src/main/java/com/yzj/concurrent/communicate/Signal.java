package com.yzj.concurrent.communicate;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-17 15:34
 */
public class Signal {
//    需要注意的是，`signal++`并不是一个原子操作，所以我们在实际开发中，会根据需要使用`synchronized`给它“上锁”，
//    或者是使用`AtomicInteger`等原子类。并且上面的程序也**并不是线程安全的**，因为执行`while`语句后，
//    可能当前线程就暂停等待时间片了，等线程醒来，可能signal已经大于等于5了。
    private static volatile int signal = 0;

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 0) {
                    System.out.println("threadA: " + signal);
                    signal++;
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 1) {
                    System.out.println("threadB: " + signal);
                    signal++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(10);
        new Thread(new ThreadB()).start();
    }

//    Non-atomic operation on volatile field 'signal'
}
