package com.intenthq.horseracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implementation of the interface <b>IHorseRacing</b>
 * 
 * @author davide romito
 * 
 */
public class HorseRacing implements IHorseRacing {
	private Set<Integer> shotValues;

	public HorseRacing(Set<Integer> set){
		this.shotValues = set;
	}
	
	public HorseRacing(){
		shotValues = new HashSet<Integer>(Arrays.asList(new Integer[] { 5, 5,
				5, 5, 10, 10, 10, 20, 20, 40, 60 }));
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.intenthq.horseracingIHorseRacing#initialize(java.util.String)
	 */
	public List<Horse> initialize(String firstLine) {
		List<Horse> horses = new ArrayList<Horse>();
		String s[] = firstLine.split(Utils.STRING_SEPARATOR);
		for (int i = 0; i < s.length && i< MAX_LINE_NUMBER; i++) {
			Horse horse = new Horse(s[i], (i + 1));
			horses.add(i, horse);
		}
		return horses;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intenthq.horseracingIHorseRacing#sortByPosition(java.util.List)
	 */
	public void sortByPosition(List<Horse> horses) {
		Collections.sort(horses, new HorseComparator());
	}

	/*
	 * (non-Javadoc)
	 * @see com.intenthq.horseracingIHorseRacing#extractHorseFromList(java.util.List,java.util.String)
	 */
	public Horse extractHorseFromList(List<Horse> horses, String line) {
		Integer lineValue = Integer.parseInt(line);
		if (lineValue <= horses.size()) {
			return horses.get(lineValue - 1);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intenthq.horseracingIHorseRacing#distanceDone(com.intenthq.horseracingApplication)
	 */
	public Boolean distanceDone(Horse horse) {
		Integer yardDone = horse.getYardDone();
		if (yardDone >= YARDS_IN_A_FURLONG) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.intenthq.horseracingIHorseRacing#insertShot(com.intenthq.horseracingHorse,java.util.String,java.util.Integer)
	 */
	public Boolean insertShot(Horse horse, String yards, Integer shotNumber) {
		Integer yardsValue = Integer.parseInt(yards);
		if (shotValues.contains(yardsValue)) {
			horse.setYardDone(horse.getYardDone() + yardsValue);
			horse.setLastShot(shotNumber);
			return true;
		} else {
			return false;
		}
	}
}
