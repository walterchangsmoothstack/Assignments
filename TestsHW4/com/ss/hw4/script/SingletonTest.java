package com.ss.hw4.script;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SingletonTest {
	Television tv1 = Television.getInstance();
	Television tv2 = Television.getInstance();

	@Test
	public void assertSameItem() throws Exception {

		assertEquals(tv1.hashCode(), tv2.hashCode());
	}

	@Test
	public void assertChangeChannel() throws Exception {
		tv1.setChannel(18);
		tv2.setChannel(51);

		assertEquals(tv1.getChannel(), new Integer(51));

	}
}
