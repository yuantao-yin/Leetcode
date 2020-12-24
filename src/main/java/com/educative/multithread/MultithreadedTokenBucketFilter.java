package com.educative.multithread;

import java.util.HashSet;
import java.util.Set;

public class MultithreadedTokenBucketFilter {
    private long possibleTokens = 0;
    private final int MAX_TOKENS;
    private final int ONE_SECOND = 1000;

    /**
     * Never start a thread in a constructor as the child thread
     * can attempt to use the not-yet-fully constructed object using this.
     * @param maxTokens
     */
    public MultithreadedTokenBucketFilter(int maxTokens) {

        MAX_TOKENS = maxTokens;
        // Never start a thread in a constructor
        Thread dt = new Thread(() -> {
            daemonThread();
        });
        dt.setDaemon(true);
        dt.start();
    }

    private void daemonThread() {
        while(true) {
            synchronized (this) {
                if (possibleTokens < MAX_TOKENS) {
                    possibleTokens++;
                }
                this.notify();
            }
            try {
                Thread.sleep(ONE_SECOND);
            } catch (InterruptedException ie) {
            }
        }
    }

    void getToken() throws InterruptedException {
        synchronized (this) {
            while (possibleTokens == 0) {
                this.wait();
            }
            possibleTokens--;
        }
        System.out.println(
            "Granting " + Thread.currentThread().getName() + " token at " + System.currentTimeMillis() / 1000);
    }

    public static void main(String[] args) throws InterruptedException {
        Set<Thread> allThreads = new HashSet<>();
        MultithreadedTokenBucketFilter bucketFilter = new MultithreadedTokenBucketFilter(5);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        bucketFilter.getToken();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.setName("Thread_"+(i+1));
            allThreads.add(thread);
        }
        for (Thread t : allThreads) {
            t.start();
        }
        for (Thread t : allThreads) {
            t.join();
        }
    }
}
