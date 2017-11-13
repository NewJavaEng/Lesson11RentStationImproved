package by.http.sportequipment.command.impl;

import java.io.FileNotFoundException;

import by.http.sportequipment.command.StationAction;
import by.http.sportequipment.entity.RentUnit;
import by.http.sportequipment.logic.RentedFileStationLogicImpl;
import by.http.sportequipment.station.RentedCatalog;

public class ViewRentedCatalogActionImpl implements StationAction {

	private RentedFileStationLogicImpl logicRented;
	{
		logicRented = new RentedFileStationLogicImpl();
	}

	@Override
	public void performAction() throws FileNotFoundException {
		RentedCatalog rentedCatalog = logicRented.readRentedCatalog();

		RentUnit[] units = rentedCatalog.getUnits();

		for (RentUnit unit : units) {
			if (unit != null) {
				System.out.println(unit);
			}
		}
	}

}
