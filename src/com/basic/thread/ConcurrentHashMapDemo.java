package com.basic.thread;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

	ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
	map.put("foo", "bar");
	map.put("han", "solo");
	map.put("r2", "d2");
	map.put("c3", "p0");

	/*
	 * The method forEach() is capable of iterating over the key-value pairs
	 * of the map in parallel. In order to visualize parallel execution we
	 * print the current threads name to the console. Keep in mind that in
	 * this case the underlying ForkJoinPool uses up to a maximum of three
	 * threads.
	 */
	map.forEach(1, (key, value) -> System.out.printf("key: %s; value: %s; thread: %s\n", key,
		value, Thread.currentThread().getName()));

	/*
	 * The method search() accepts a BiFunction returning a non-null search
	 * result for the current key-value pair or null if the current
	 * iteration doesn't match the desired search criteria. If multiple
	 * entries of the map match the given search function the result may be
	 * non-deterministic.
	 */
	String result = map.search(1, (key, value) -> {
	    System.out.println(Thread.currentThread().getName());
	    if ("foo".equals(key)) {
		return value;
	    }
	    return null;
	});
	System.out.println("Result: " + result);
    }
}
