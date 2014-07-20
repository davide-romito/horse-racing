package com.intenthq.horseracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility for the package
 * 
 * @author davide romito
 * 
 */
public class Utils {
	private Utils() {
	}

	public final static String HEADER = "Position, Lane, Horse name";
	public final static String LINE_SEPARATOR = "\n";
	public final static String STRING_SEPARATOR = ", ";

	/**
	 * Create a list of string starting from a string, using the value of
	 * LINE_SEPARATOR
	 * 
	 * @param input
	 *            - a string
	 * @return a list of string
	 */
	public static List<String> manipulateInput(String input) {
		return new ArrayList<String>(Arrays.asList(input.split(LINE_SEPARATOR)));
	}

	/**
	 * Split a string using the white space. If the are less than 2 objects in
	 * the array, the first element will be set at <i>2147483647</i>
	 * 
	 * @param line
	 *            - a string
	 * @return an array of strings or null if line is empty
	 */
	public static String[] manipulateLine(String line) {
		if (line != null && !line.isEmpty()) {
			String[] arr = line.split("\\s{1,}");
			if (arr.length > 0) {
				if (arr.length < 2) {
					arr[0] = String.valueOf(Integer.MAX_VALUE);
				}
				return arr;
			}
		}
		return null;
	}

	/**
	 * Format the output
	 * 
	 * @param list
	 *            - list of object
	 * @return the formatted output
	 */
	public static String printResult(@SuppressWarnings("rawtypes") List list) {
		StringBuilder sb = new StringBuilder(HEADER);
		for (int i = 0; i < list.size(); i++) {
			sb.append(LINE_SEPARATOR);
			sb.append((i + 1));
			sb.append(STRING_SEPARATOR);
			sb.append(list.get(i));
		}
		return sb.toString();
	}

}
