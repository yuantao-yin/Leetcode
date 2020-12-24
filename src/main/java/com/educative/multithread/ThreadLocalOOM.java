package com.educative.multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalOOM {
    private static final int TASK_LOOP_SIZE = 500;

    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,5,
        1, TimeUnit.MINUTES,new LinkedBlockingDeque<Runnable>());

    static class LocalLargeVariable{
        //初始化一个5M的数组
        private byte[] bytes = new byte[1024*1024*5];
    }

    static final ThreadLocal<LocalLargeVariable> localVariable = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < TASK_LOOP_SIZE; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("use local variable");
                    // 场景一:
                    //new LocalLargeVariable();  //占用内存大概是25M
                    // 场景二:
                    // 虽然set()方法也能置空Entry的引用, 等待GC回收, 但并不那么及时 占用内存大概是110M
                    //localVariable.set(new LocalLargeVariable());
                    // 场景三:
                    // 结尾使用remove() 方法, 占用内存大概是20M
                    localVariable.set(new LocalLargeVariable());
                    // remove() 放在线程结束的时候使用,但并不是必须，可以加快内存回收
                    localVariable.remove();
                }
            });
            Thread.sleep(100);
        }
        System.out.println("thread execute over！");
    }
}
