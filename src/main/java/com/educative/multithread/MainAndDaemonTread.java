package com.educative.multithread;

public class MainAndDaemonTread {

    public static void main(String[] args) throws InterruptedException{
        ExecuteMe em = new ExecuteMe();
        Thread innerThread = new Thread(em);
        innerThread.setDaemon(true);
        innerThread.start();
        /**
         * Without join(), the thread won't continuously run. That is
         * because the main thread exits right after starting the innerThread.
         * Once it exits, the JVM also kills the spawned thread.
         *
         * If we want the main thread to wait for the innerThread to finish before
         * proceeding forward, we can direct the main thread to suspend its execution
         * by calling join method on the innerThread object right after we start the
         * innerThread. The change would look like the following.
         */
        innerThread.join();
    }
}

class ExecuteMe implements Runnable {

    @Override
    public void run() {
        while(true) {
            System.out.println("Say Hello over and over again.");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}