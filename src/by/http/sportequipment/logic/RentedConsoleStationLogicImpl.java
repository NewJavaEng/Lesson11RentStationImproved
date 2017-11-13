package by.http.sportequipment.logic;

import java.io.FileNotFoundException;

import by.http.sportequipment.entity.Equipment;
import by.http.sportequipment.entity.RentUnit;
import by.http.sportequipment.station.RentedCatalog;

public class RentedConsoleStationLogicImpl implements RentedStationLogic {

	@Override
	public RentedCatalog readRentedCatalog() throws FileNotFoundException {
		Equipment eq1 = new Equipment("Eq17");
		Equipment eq2 = new Equipment("Eq24");
		Equipment eq3 = new Equipment("Eq31");
		Equipment eq4 = new Equipment("Eq45");

		RentUnit re1 = new RentUnit(eq1, 3.5);
		RentUnit re2 = new RentUnit(eq2, 5.5);
		RentUnit re3 = new RentUnit(eq3, 7.5);
		RentUnit re4 = new RentUnit(eq4, 8.5);

		RentedCatalog rentedCatalog = new RentedCatalog();
		rentedCatalog.addRentUnit(re1);
		rentedCatalog.addRentUnit(re2);
		rentedCatalog.addRentUnit(re3);
		rentedCatalog.addRentUnit(re4);
		return rentedCatalog;
	}

}
