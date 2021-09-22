package com.ss.hw4.script;

import java.util.Arrays;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Walter Chang Creates a 10 int buffer that allows a producer and
 *         consumer to add and get ints within shared memory
 *
 */
class Consumer implements Runnable {
	Buffer buf;

	/*
	 * Starts a thread automatically in the constructor. Takes in a Buffer item
	 * which will be the same one used by the consumer
	 */
	public Consumer(Buffer buf) {
		this.buf = buf;
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		/* Continue to consume items by calling the consume function */
		while (true) {

			System.out.println("Get number: " + buf.consume());

		}
	}
}

class Producer implements Runnable {
	Buffer buf;

	/* Same constructor format, starts thread once called */
	public Producer(Buffer buf) {
		this.buf = buf;
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		/*
		 * Continuously produce items (random int ranging from 0-99) and adding them to
		 * the buffer array
		 */
		while (true) {

			int x = (int) Math.floor(Math.random() * 100);
			System.out.println("Produce Number: " + x);
			buf.produce(x);

		}
	}

}

/* Handles multi-threading issues */
class Buffer {
	/* count keeps track of array index */
	AtomicInteger count = new AtomicInteger(0);
	int[] buffer = new int[10];

	/*
	 * if the count is greater than or equal to 9, wait until it is decremented by
	 * consume
	 */
	public void produce(int num) {
		while (count.get() > 9) {
			try {
				wait();

			} catch (Exception e) {

			}
		}
		synchronized (count) {
			buffer[count.get()] = num;
			count.incrementAndGet();
			System.out.println(Arrays.toString(buffer));
		}

	}

	/*
	 * if count is less than or equal to 0, wait until it is incremented by produce
	 */
	public int consume() {
		while (count.get() <= 0) {
			try {
				wait();

			} catch (Exception e) {

			}
		}
		synchronized (count) {
			int result = buffer[count.get() - 1];
			buffer[count.get() - 1] = 0;
			count.decrementAndGet();
			return result;
		}

	}

}

public class ProducerConsumer {

	public static void main(String[] args) {
		/* Call constructors */
		Buffer buf = new Buffer();
		new Producer(buf);
		new Consumer(buf);

	}

}
