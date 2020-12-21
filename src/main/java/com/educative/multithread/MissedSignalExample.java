package com.educative.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MissedSignalExample {

    public static void example() throws InterruptedException {

        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        Thread signaller = new Thread(new Runnable() {

            public void run() {
                lock.lock();
                condition.signal();
                System.out.println("Sent signal");
                lock.unlock();
            }
        });

        Thread waiter = new Thread(new Runnable() {

            public void run() {

                lock.lock();

                try {
                    condition.await();
                    System.out.println("Received signal");
                } catch (InterruptedException ie) {
                    // handle interruption
                }

                lock.unlock();

            }
        });



        waiter.start();
        waiter.join();
        signaller.start();
        signaller.join(); // wait for other thread to finish

        System.out.println("Program Exiting.");
    }

    public static void main(String args[]) throws InterruptedException {
        // A missed signal happens when a signal is sent by a thread before
        // the other thread starts waiting on a condition.
        MissedSignalExample.example();
    }
}
