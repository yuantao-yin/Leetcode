package com.basic.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
    
    public static void main(String[] args) {
	ExecutorService executor = Executors.newSingleThreadExecutor();
	executor.submit(() -> {
	    String threadName = Thread.currentThread().getName();
	    System.out.println("Hello " + threadName);
	});
	
	Callable<Integer> task = () -> {
	    try {
	        TimeUnit.SECONDS.sleep(1);
	        return 123;
	    }
	    catch (InterruptedException e) {
	        throw new IllegalStateException("task interrupted", e);
	    }
	};
	Future<Integer> future = executor.submit(task);

	System.out.println("future done? " + future.isDone());

	Integer result;
	try {
	    result = future.get();
	    System.out.println("future done? " + future.isDone());
	    System.out.println("result: " + result);
	} catch (InterruptedException e1) {
	    e1.printStackTrace();
	} catch (ExecutionException e1) {
	    e1.printStackTrace();
	}

	
	
	try {
	    System.out.println("attempt to shutdown executor");
	    executor.shutdown();
	    executor.awaitTermination(5, TimeUnit.SECONDS);
	}
	catch (InterruptedException e) {
	    System.err.println("tasks interrupted");
	}
	finally {
	    if (!executor.isTerminated()) {
	        System.err.println("cancel non-finished tasks");
	    }
	    executor.shutdownNow();
	    System.out.println("shutdown finished");
	}
	
	
    }
}
