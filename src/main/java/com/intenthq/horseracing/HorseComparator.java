package com.intenthq.horseracing;

import java.util.Comparator;

/**
 * This class is used to implements the comparator. It will be user to sort any
 * collection of Horse
 * 
 * @author davide romito
 * 
 */
public class HorseComparator implements Comparator<Horse> {

	/**
	 * This method compare two horses based on yardDone parameter. If the
	 * yardDones are equals, lastShot will be used to compare the two objects.
	 */
	public int compare(Horse o1, Horse o2) {
		Integer yardDoneByHorse1 = o1.getYardDone();
		Integer yardDoneByHorse2 = o2.getYardDone();
		if (yardDoneByHorse1 == yardDoneByHorse2) {
			/* Ascending order */
			return (o1.getLastShot().compareTo(o2.getLastShot()));
		} else {
			/* Descending order */
			return -1 * yardDoneByHorse1.compareTo(yardDoneByHorse2);
		}
	}

}
