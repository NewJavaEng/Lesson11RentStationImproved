package by.http.sportequipment.command.impl;

import java.io.FileNotFoundException;

import by.http.sportequipment.command.StationAction;
import by.http.sportequipment.entity.RentUnit;
import by.http.sportequipment.logic.FileStationLogicImpl;
import by.http.sportequipment.logic.StationLogic;
import by.http.sportequipment.station.Catalog;

public class ViewCatalogActionImpl implements StationAction {

	private StationLogic logic;
	{
		// logic = new ConsoleStationLogicImpl();
		logic = new FileStationLogicImpl();
		// logic = nre DataBaseStationlLogicImpl();
	}

	@Override
	public void performAction() throws FileNotFoundException {
		Catalog catalog = logic.readCatalog();

		RentUnit[] units = catalog.getUnits();

		for (RentUnit unit : units) {
			if (unit != null) {
				System.out.println(unit);
			}
		}

	}

}
