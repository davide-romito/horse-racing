package com.intenthq.horseracing;

import java.util.List;

/**
 * This class represent the operation to do during the horse competition
 * 
 * @author davide romito
 * 
 */

public interface IHorseRacing {
	Integer YARDS_IN_A_FURLONG = 220;
	Integer MAX_LINE_NUMBER = 7;

	/**
	 * This method return a list of horses read from the first line of the
	 * input. The index of the list represent the line -1 where the horse is.
	 * 
	 * @param firstString
	 *            - a string where the name are separated by common
	 * @return a list of objects Horse
	 */
	List<Horse> initialize(String firstString);

	/**
	 * This method sort a list of object Horse based on the parameter yardDone.
	 * If two objects have the same value of yardDone, lastShoot will be used to
	 * find who arrived first.
	 * 
	 * @param horses
	 *            - a list of unordered objects Horse
	 */
	void sortByPosition(List<Horse> horses);

	/**
	 * Select the object Horse using the parameter line. If the parameter line
	 * will be greater than the max number of horses in the list, the method
	 * will return a null value.
	 * 
	 * @param horses
	 *            - a list of horses
	 * @param line
	 *            - a parameter that represent the line where is the horse
	 * @return the object Horse in the line <b>line</b>; null if the parameter
	 *         is greater than the size of the list
	 */
	Horse extractHorseFromList(List<Horse> horses, String line);

	/**
	 * This method calculate if the distance of an Horse object is more or less
	 * than a YARDS_IN_A_FURLONG
	 * 
	 * @param horse
	 *            - object horse
	 * @return true if the distance of the horse is equals or more than a
	 *         YARDS_IN_A_FURLONG; else false
	 */
	Boolean distanceDone(Horse horse);

	/**
	 * Update the value of yards done and the shot number of an horse. This
	 * method will return false if the value yards is not a possible value
	 * 
	 * @param horse
	 *            - the object Horse to update
	 * @param yards
	 *            - the value of the yard given from a shot
	 * @param shotNumber
	 *            - the index of the total shots
	 * @return false if the value <b>yards</b> is not a possible value, else
	 *         true
	 */
	Boolean insertShot(Horse horse, String yards, Integer shotNumber);
}
