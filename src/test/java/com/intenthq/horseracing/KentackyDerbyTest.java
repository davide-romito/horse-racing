package com.intentihq.horseracing;

import com.intenthq.horseracing.KentuckyDerby;

import junit.framework.TestCase;

public class KentackyDerbyTest extends TestCase {

	KentuckyDerby kd;
	String input = "Star, Dakota, Cheyenne, Misty, Spirit\n1 60\n3 5\n1 60\n4 5\n4 10\n2 5\n5 10\n1 60\n3 20\n7 10\n1 40\n2 60";
	String expectedOutput = "Position, Lane, Horse name\n1, 1, Star\n2, 3, Cheyenne\n3, 4, Misty\n4, 5, Spirit\n5, 2, Dakota";

	protected static void setUpBeforeClass() throws Exception {
	}

	protected static void tearDownAfterClass() throws Exception {
	}

	protected void setUp() throws Exception {
		super.setUp();
		kd = new KentuckyDerby();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link com.intenthq.horseracingKentackyDerby#play(java.lang.String)}
	 * .
	 */
	public void testPlay() {
		String actualOutput = kd.play(input);
		assertEquals(expectedOutput, actualOutput);
	}

}
