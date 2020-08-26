package com.basic.thread;

import java.lang.Thread.State;
import java.util.concurrent.atomic.AtomicReference;

public class UnreentrantLock {
	private AtomicReference<Thread> owner = new AtomicReference<Thread>();

    public void lock() {
        Thread current = Thread.currentThread();
        //这句是很经典的“自旋”语法，AtomicInteger中也有
        for (;;) {
            if (!owner.compareAndSet(null, current)) {
                return;
            }
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
    }
    
    public static void main(String[] args) {
    	UnreentrantLock ulk = new UnreentrantLock();
    	ulk.lock();
    	ulk.lock();
    	Thread current = Thread.currentThread();
    	State state = current.getState();
    	System.out.println(state.name());
    }
}
