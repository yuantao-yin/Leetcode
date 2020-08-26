package com.basic.thread;

public class Java8LambdaRunnable implements Runnable {

    public static void main(String [] args) {
	Runnable task = () -> {
	    String threadName = Thread.currentThread().getName();
	    System.out.println("Hello " + threadName);
	};

	task.run();

	Thread thread = new Thread(task);
	thread.start();

	System.out.println("Done!");
    }

    @Override
    public void run() {
	// TODO Auto-generated method stub
	
    }
    
}
