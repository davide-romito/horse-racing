package com.intentihq.horseracing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import com.intenthq.horseracing.Horse;
import com.intenthq.horseracing.HorseComparator;

public class HorseComparatorTest extends TestCase {

	private HorseComparator hc;
	private Horse h1;
	private Horse h2;
	private Horse h3;
	private Horse h4;

	protected static void setUpBeforeClass() throws Exception {
	}

	protected static void tearDownAfterClass() throws Exception {
	}

	protected void setUp() throws Exception {
		super.setUp();
		hc = new HorseComparator();
		h1 = new Horse(1);
		h2 = new Horse(2);
		h3 = new Horse(3);
		h4 = new Horse(4);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.HorseComparator#compare(com.intenthq.horseracing.Horse,com.intenthq.horseracing.Horse)}
	 * .
	 */
	public void testCompareWithYardsDifferent() {
		h1.setYardDone(100);
		h2.setYardDone(10);
		assertEquals(-1, hc.compare(h1, h2));
		assertEquals(1, hc.compare(h2, h1));
	}

	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.HorseComparator#compare(com.intenthq.horseracing.Horse,com.intenthq.horseracing.Horse)}
	 * .
	 */
	public void testCompareWithYardsEqual() {
		h1.setYardDone(10);
		h1.setLastShot(1);
		h2.setYardDone(10);
		h2.setLastShot(3);
		assertEquals(-1, hc.compare(h1, h2));
		assertEquals(1, hc.compare(h2, h1));
	}

	/**
	 * Test method for
	 * {@link com.intenthq.horseracing.HorseComparator#compare(com.intenthq.horseracing.Horse,com.intenthq.horseracing.Horse)}
	 * .
	 */
	public void testCompareList() {
		h1.setYardDone(100);
		h1.setLastShot(1);
		h2.setYardDone(40);
		h2.setLastShot(3);
		h3.setYardDone(60);
		h3.setLastShot(4);
		h4.setYardDone(60);
		h4.setLastShot(2);
		Horse[] hs1 = new Horse[] { h1, h2, h3, h4 };
		List<Horse> actualList = Arrays.asList(hs1);
		Collections.sort(actualList, hc);
		Horse[] hs2 = new Horse[] { h1, h4, h3, h2 };
		List<Horse> expectedlist = Arrays.asList(hs2);
		for (int i = 0; i < actualList.size(); i++) {
			assertEquals(expectedlist.get(i), actualList.get(i));
		}
	}
}
