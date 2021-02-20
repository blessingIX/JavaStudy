package com.yzj.concurrent.support;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-23 16:49
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Pool pool = new Pool();
        for (int i = 0; i < 10; i++) {
            Sleep item = (Sleep) pool.getItem();
            if (item != null) {
                pool.putItem(item.sleep());
            } else {
                pool.putItem(null);
            }
        }
    }
}

/**
 * JDK文档 Semaphore类 说明中的例子：这是一个使用信号量来控制对一个项目池的访问的类
 */
class Pool {
    private static final int MAX_AVAILABLE = 3;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    /**
     * 从池中拿出一个
     * @return
     * @throws InterruptedException
     */
    public Object getItem() throws InterruptedException {
        available.acquire();
        return getNextAvailableItem();
    }

    public void putItem(Object x) {
        if (markAsUnused(x))
            available.release();
    }
    // Not a particularly efficient data structure; just for demo
    protected Object[] items = new Sleep[10]; // ... whatever kinds of items being managed
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    protected synchronized Object getNextAvailableItem() {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (!used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        return null;
        // not reached
    }

    protected synchronized boolean markAsUnused(Object item) {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (item == items[i]) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else
                    return false;
            }
        }
        return false;
    }
}

/**
 * 睡觉类，用于测试Pool类
 */
class Sleep {

    public Sleep sleep() {
        try {
            int sec = new Random().nextInt(10) + 1;
            System.out.println(this + "睡" + sec + "秒");
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        return this;
    }

}
