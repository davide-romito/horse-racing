package com.intenthq.horseracing;

/**
 * This class model the object horse
 * 
 * @author davide romito
 * 
 */
public class Horse {

	private String name;
	private Integer line;
	private Integer lastShot;
	private Integer yardDone;

	public Horse(String name, Integer line) {
		this(line);
		this.name = name;
	}

	public Horse(Integer line) {
		super();
		this.line = line;
		this.yardDone = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public Integer getLastShot() {
		return lastShot;
	}

	public void setLastShot(Integer lastShot) {
		this.lastShot = lastShot;
	}

	public Integer getYardDone() {
		return yardDone;
	}

	public void setYardDone(Integer yardDone) {
		this.yardDone = yardDone;
	}

	@Override
	public String toString() {
		return line + ", " + name;
	}

	@Override
	/*
	 * Two objects horse are equals if the name and the line are equals
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Horse other = (Horse) obj;
		if (line == null) {
			if (other.line != null) {
				return false;
			}
		} else if (!line.equals(other.line)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
