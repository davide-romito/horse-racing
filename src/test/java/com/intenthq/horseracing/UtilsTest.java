package com.intentihq.horseracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import com.intenthq.horseracing.Horse;
import com.intenthq.horseracing.Utils;

public class UtilsTest extends TestCase {
	private List<Horse> returnList;
	private Horse h1;
	private Horse h2;

	protected static void setUpBeforeClass() throws Exception {
	}

	protected static void tearDownAfterClass() throws Exception {
	}

	protected void setUp() throws Exception {
		super.setUp();
		h1 = new Horse("Star", 1);
		h2 = new Horse("Cheyenne", 2);
		returnList = new ArrayList<Horse>(Arrays.asList(new Horse[] { h1, h2 }));
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.Utils#manipulateInput(java.lang.String)}
	 * .
	 */
	public void testManipulateInput() {
		String input = "Star\nDakota\nCheyenne";
		List<String> list = Utils.manipulateInput(input);
		String[] expected = new String[] { "Star", "Dakota", "Cheyenne" };
		for (int i = 0; i < list.size(); i++) {
			assertEquals(expected[i], list.get(i));
		}
	}

	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.Utils#manipulateLine(java.lang.String)}
	 * .
	 */
	public void testManipulateLine() {
		String[] expectedArr = new String[] { "1", "5" };
		String line = "1 5";
		String[] actualArr = Utils.manipulateLine(line);
		for (int i = 0; i < actualArr.length; i++) {
			assertEquals(expectedArr[i], actualArr[i]);
		}
		line = "1    5";
		actualArr = Utils.manipulateLine(line);
		for (int i = 0; i < actualArr.length; i++) {
			assertEquals(expectedArr[i], actualArr[i]);
		}
	}

	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.Utils#manipulateLine(java.lang.String)}
	 * .
	 */
	public void testManipulateLineError() {
		String expectedValue = String.valueOf(Integer.MAX_VALUE);
		String line = "1";
		String[] actualArr = Utils.manipulateLine(line);
		assertEquals(expectedValue, actualArr[0]);

	}

	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.Utils#printResult(java.util.List)}
	 * .
	 */
	public void testPrintResult() {
		String expectedOutput = "Position, Lane, Horse name\n1, 1, Star\n2, 2, Cheyenne";
		String actualOutput = Utils.printResult(returnList);
		assertEquals(expectedOutput, actualOutput);
	}

}
