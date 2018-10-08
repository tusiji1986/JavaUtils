package com.tusiji.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadLocalTest {
	private static ThreadLocal<Integer> t1 = new InheritableThreadLocal<Integer>();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		t1.set(1);
		
		executor.submit(new DoTask());
		executor.submit(new DoTask());
		executor.submit(new DoTask());
		executor.submit(new DoTask());
		executor.submit(new DoTask());
		executor.submit(new DoTask());
		executor.submit(new DoTask());

		executor.shutdown();
		System.out.println(Thread.currentThread().getName()+" "+t1.get());

	}
	
	static class DoTask implements Runnable {
		public void run() {
			System.out.println(Thread.currentThread().getName()+" "+t1.get());
		}
		
	}

}
