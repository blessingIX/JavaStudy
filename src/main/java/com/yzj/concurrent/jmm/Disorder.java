package com.yzj.concurrent.jmm;

/**
 * @description: 验证CPU乱序执行（语句级别，语句级别存在乱序，指令级别自然存在），此处为反证法（若不存在 (0, 0) 情况则证明没有乱序执行）
 * @author: 易子建
 * @create: 2020-11-28 16:16
 */
public class Disorder {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int i = 0;
        for(;;) {
            i++;
            x = 0; y = 0;
            a = 0; b = 0;
            Thread one = new Thread(() -> {
                // 由于线程one先启动，下面这条语句让它等一等线程tow，可根据自己电脑的实际性能适当调整等待时间。
                // shortWait(100000);
                a = 1;
                x = b;
            });

            Thread other = new Thread(() -> {
                b = 1;
                y = a;
            });
            one.start();other.start();
            one.join();other.join();
            String result = "第" + i + "次（" + x + ", " + y + "）";
            if (x == 0 && y == 0) {
                long end = System.currentTimeMillis();
                System.err.println(result);
                System.out.println("执行" + (end - start) / 1000 + "秒");
                break;
            } else {
//                System.out.println(result);
            }
        }
    }

    public static void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }
}
