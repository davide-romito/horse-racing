package com.intentihq.horseracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import com.intenthq.horseracing.Horse;
import com.intenthq.horseracing.HorseRacing;

public class HorseRacingTest extends TestCase {

	HorseRacing hr;
	private Horse h1;
	private Horse h2;
	private Horse h3;
	private Horse h4;
	private List<Horse> returnList;

	protected static void setUpBeforeClass() throws Exception {
	}

	protected static void tearDownAfterClass() throws Exception {
	}

	protected void setUp() throws Exception {
		super.setUp();
		hr = new HorseRacing();
		h1 = new Horse("a", 1);
		h2 = new Horse("b", 2);
		h3 = new Horse("c", 3);
		h4 = new Horse("d", 4);
		returnList = new ArrayList<Horse>(Arrays.asList(new Horse[] { h1, h2, h3, h4 }));
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.HorseRacing#initialize(java.lang.String)}
	 * .
	 */
	public void testInitialize() {
		String str = "a, b, c, d";
		List<Horse> actualList = hr.initialize(str);
		for (int i = 0; i < actualList.size(); i++) {
			assertEquals(returnList.get(i), actualList.get(i));
		}
	}

	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.HorseRacing#sortByPosition(java.util.List)}
	 * .
	 */
	public void testSortByPosition() {
		h1.setYardDone(100);
		h2.setYardDone(90);
		h3.setYardDone(80);
		h4.setYardDone(70);
		List<Horse> actualList = new ArrayList<Horse>(Arrays.asList(new Horse[] { h3, h2, h4, h1 }));
		hr.sortByPosition(actualList);
		for (int i = 0; i < actualList.size(); i++) {
			assertEquals(returnList.get(i), actualList.get(i));
		}
	}

	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.HorseRacing#extractHorseFromList(java.util.List,java.lang.String)}
	 * .
	 */
	public void testExtractHorseFromList() {
		Horse actualHorse = hr.extractHorseFromList(returnList, "1");
		assertEquals(h1, actualHorse);
		actualHorse = hr.extractHorseFromList(returnList, "3");
		assertEquals(h3, actualHorse);
	}

	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.HorseRacing#distanceDone(com.intenthq.horseracing.Horse)}
	 * .
	 */
	public void testDistanceDone() {
		h2.setYardDone(10);
		assertFalse(hr.distanceDone(h2));
		h2.setYardDone(220);
		assertTrue(hr.distanceDone(h2));
	}

	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.HorseRacing#insertShot(com.intenthq.horseracing.Horse,java.lang.String,java.lang.Integer)}
	 * .
	 */
	public void testInsertShotPossibleValuesDefault() {
		assertTrue(hr.insertShot(h3, "60", 1));
		assertTrue(hr.insertShot(h3, "40", 1));
		assertTrue(hr.insertShot(h3, "20", 1));
		assertTrue(hr.insertShot(h3, "10", 1));
		assertTrue(hr.insertShot(h3, "5", 1));
		assertFalse(hr.insertShot(h3, "50", 1));
		assertFalse(hr.insertShot(h3, "30", 1));
		assertFalse(hr.insertShot(h3, "15", 1));
	}
	
	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.HorseRacing#insertShot(com.intenthq.horseracing.Horse,java.lang.String,java.lang.Integer)}
	 * .
	 */
	public void testInsertShotPossibleValuesCustom() {
		Set<Integer> customValues = new HashSet<Integer>(Arrays.asList(new Integer[] { 15, 30, 50 }));
		HorseRacing hrCustom = new HorseRacing(customValues);
		assertFalse(hrCustom.insertShot(h4, "60", 1));
		assertFalse(hrCustom.insertShot(h4, "40", 1));
		assertFalse(hrCustom.insertShot(h4, "20", 1));
		assertFalse(hrCustom.insertShot(h4, "10", 1));
		assertFalse(hrCustom.insertShot(h4, "5", 1));
		assertTrue(hrCustom.insertShot(h4, "50", 1));
		assertTrue(hrCustom.insertShot(h4, "30", 1));
		assertTrue(hrCustom.insertShot(h4, "15", 1));
	}
	
	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.HorseRacing#insertShot(com.intenthq.horseracing.Horse,java.lang.String,java.lang.Integer)}
	 * .
	 */
	public void testInsertShot() {
		hr.insertShot(h1, "60", 1);
		assertEquals(60, (int) h1.getYardDone());
		hr.insertShot(h1, "10", 1);
		assertEquals(70, (int) h1.getYardDone());
	}

}
