/**
 * 
 */
package com.ss.wk1.review;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Walter Chang
 *
 */
public class SampleSingleton {
	private static Connection conn = null;
	private static SampleSingleton instance = null;
	
	/* Double check locking */
	public static SampleSingleton getInstance() {
		/* If not null, then take advantage of multi-threading and 
		 * do not enter into synchronized block*/
		if(instance == null) {
			synchronized(instance) {
				if(instance == null) {
					instance = new SampleSingleton();
				}
				
			}
		}
		
		
		return instance;
		
		
		
	}

}
