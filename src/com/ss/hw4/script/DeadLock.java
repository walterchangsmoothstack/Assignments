/**
 * 
 */
package com.ss.hw4.script;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Walter Chang Creates a deadlock using two threads requesting two int
 *         arrays
 */


public class DeadLock {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[0];
		int[] b = new int[0];
		
		/* Thread one calls a and then b*/
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				synchronized (a) {
					System.out.println("Waiting for b");

					synchronized (b) {
						//Never printed
						System.out.println("Got b");
					}
				}
			}
		});
		
		/* Thread two calls b and then a*/
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				synchronized (b) {
					System.out.println("Waiting for a");

					synchronized (a) {
						//Never printed
						System.out.println("Got a");

					}
				}
			}
		});
		/* Deadlock is created when both a and b are in synchronized blocks
		 * but are waiting for each other to be released for access */
		t1.start();
		t2.start();

	}

}
