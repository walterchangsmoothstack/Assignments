package com.ss.hw4.script;

/**
 * @author Walter Chang
 * Creates a singleton design pattern for a Television object
 *
 */
class Television {
	/* Includes one Television object to be passed and an integer for channel number*/
	public static volatile Television instance = null;
	private Integer channel;
		/* Standard Singleton private constructor*/
		private Television() {
			
		}
		/* Double check locking to ensure that multi-threading will continue
		   if the Television has already been declared. Otherwise, synchronized
		   block to ensure that the first instance of Television is passed only
		   once. */
		public static Television getInstance() {
			if(instance == null) {
				synchronized(Television.class) {
					if(instance == null) {
						instance = new Television();
					}
				}			
			}
			return instance;
			
		}
		/* Multiple people can change the channel at once, the Television
		 * should not flip through all channels until the last one, but simply
		 * immediately switch to a channel */
		public void setChannel(Integer channel) {
				this.channel = channel;
			
		}
		
		public Integer getChannel() {
			return this.channel;
		
	}
}


public class Singleton {
	
	public static void main (String[]args) {
		/* Quick check to ensure only one object is instantiated */
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i =0; i<1000; i++) {
					Television tv = Television.getInstance();
					System.out.println(tv.hashCode());
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for(int i =0; i<1000; i++) {
					Television tv = Television.getInstance();
					System.out.println(tv.hashCode());
				}
			}
		});
		t1.start();
		t2.start();
		
	}

}
