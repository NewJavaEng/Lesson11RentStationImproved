package by.http.sportequipment.station;

import by.http.sportequipment.entity.RentUnit;

public class RentedCatalog {

	private static final int DEFAULT_CAPACITY = 10;
	private RentUnit[] units;
	private int lastIndex;

	public RentedCatalog() {

		units = new RentUnit[DEFAULT_CAPACITY];
		lastIndex = 0;

	}

	public int getLastIndex() {
		return lastIndex;
	}

	public RentUnit[] getUnits() {
		return units;
	}

	public RentUnit getLastRentUnit() {
		return units[lastIndex - 1];
	}

	public void addRentUnit(RentUnit unit) {
		units[lastIndex] = unit;
		lastIndex++;
	}

}
