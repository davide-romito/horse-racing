package com.intenthq.horseracing;

import java.util.List;

/**
 * This class simulate the horse racing derby game known as Kentucky Derby.
 * 
 * @author davide romito
 * 
 */
public class KentuckyDerby {

	/**
	 * This method simulate the horse racing
	 * 
	 * @param input
	 *            <ul>
	 *            <li>
	 *            The first line of the input will contain the names of the
	 *            horses ordered according to the lane they will be running in:
	 *            <code>HORSE1, HORSE2, ....</code></li>
	 *            <li>
	 *            The rest of the lines of the input will represent a ball
	 *            throw. The format will be: <code>LANE_NUMBER YARDS</code>.</li>
	 *            </ul>
	 * @return <p>
	 *         The output will be the list of horses ordered by position in the
	 *         race:
	 * 
	 *         <pre>
	 *       Position, Lane, Horse name
	 *       1, 2, HORSE2
	 *       2, 5, HORSE5
	 * </pre>
	 * 
	 *         </p>
	 */
	public String play(String input) {
		/* First step : create a list of strings from the input */
		List<String> inputList = Utils.manipulateInput(input);
		IHorseRacing hr = new HorseRacing();
		/*
		 * Second step : create a list of horses starting from the first line of
		 * the list inputList
		 */
		List<Horse> horses = hr.initialize(inputList.get(0));

		/*
		 * Third step : reading the value of the list, update the values until
		 * the goal is reached
		 */
		for (int i = 1; i < inputList.size(); i++) {
			String[] x = Utils.manipulateLine(inputList.get(i));
			if (x == null) {
				/* Skip if the manipulateLine return a null value */
				continue;
			}
			Horse h = hr.extractHorseFromList(horses, x[0]);
			if (h == null) {
				/* Skip if there is a line where isn't an horse */
				continue;
			}
			hr.insertShot(h, x[1], i + 1);
			if (hr.distanceDone(h)) {
				/* Frozen the game when the goal is reached */
				break;
			}
		}

		/*
		 * Fourth step : sort the list of horses based on the yards done, and
		 * the last shot done
		 */
		hr.sortByPosition(horses);

		/* Fifth step : format the output */
		return Utils.printResult(horses);
	}

}
