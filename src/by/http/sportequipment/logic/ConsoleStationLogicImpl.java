package by.http.sportequipment.logic;

import by.http.sportequipment.entity.Equipment;
import by.http.sportequipment.entity.RentUnit;
import by.http.sportequipment.station.Catalog;

public class ConsoleStationLogicImpl implements StationLogic {

	public Catalog readCatalog() {

		Equipment eq1 = new Equipment("Eq1");
		Equipment eq2 = new Equipment("Eq2");
		Equipment eq3 = new Equipment("Eq3");

		RentUnit re1 = new RentUnit(eq1, 2.5);
		RentUnit re2 = new RentUnit(eq2, 2.5);
		RentUnit re3 = new RentUnit(eq3, 2.5);

		Catalog catalog = new Catalog();
		catalog.addRentUnit(re1);
		catalog.addRentUnit(re2);
		catalog.addRentUnit(re3);
		return catalog;
	}

}
